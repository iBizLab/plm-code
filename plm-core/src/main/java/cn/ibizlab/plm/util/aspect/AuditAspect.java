/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/aspect/AuditAspect.java.hbs
 */
package cn.ibizlab.plm.util.aspect;

import cn.ibizlab.util.helper.BeanCache;
import lombok.SneakyThrows;
import cn.ibizlab.util.annotation.Audit;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.service.IBZDataAuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 实体数据审计切面类
 *
 * @author generator
 */
//@Aspect
//@Component
public class AuditAspect
{
    private final ExpressionParser parser = new SpelExpressionParser();

    @Autowired
    IBZDataAuditService dataAuditService;

    /**
     * 实体数据建立切面，在成功创建数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.*.create(..))")
    @SneakyThrows
    public void create(JoinPoint point) {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            request = ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return;
        }
        Object serviceParam = args[0];
        if(serviceParam instanceof EntityBase) {
            EntityBase entity = (EntityBase)serviceParam;
            //记录审计日志
            if(BeanCache.hasAudit(entity.getClass()))
                dataAuditService.createAudit(request, entity, null);
        }
        else if(serviceParam instanceof List && !ObjectUtils.isEmpty(serviceParam)) {
            List list=(List<?>) serviceParam;
            if(list.get(0) instanceof EntityBase && BeanCache.hasAudit(list.get(0).getClass())) {
                for(Object entity:list)
                    dataAuditService.createAudit(request, (EntityBase)entity, null);
            }
        }
    }

    /**
     * 实体数据更新切面，在成功更新数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * 使用环切【@Around】获取到更新前后的实体数据并进行差异比较，并将差异内容记入审计日志内
     * @param point
     */
    @Around("execution(* cn.ibizlab.plm.core.*.service.*.update(..))")
    public Object update(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            request=((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object serviceObj = point.getTarget();
        Object args[] = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return point.proceed();
        }
        Object serviceParam = args[0];
        if(serviceParam instanceof EntityBase) {
            EntityBase entity = (EntityBase) serviceParam;
            BeanCache.BeanSchema schema = BeanCache.get(entity.getClass());
            if(schema.isHasAudit())
            {
                String idField = schema.getKeyField().getCodeName();
                Object idValue = "";
                if(!StringUtils.isEmpty(idField)){
                    idValue = entity.get(idField);
                }
                if(ObjectUtils.isEmpty(idValue)) {
                    return point.proceed();
                }
                //获取更新前实体
                EntityBase beforeEntity = schema.getAudits().isEmpty()?entity:getEntity(serviceObj, idValue, entity.getClass());
                //执行更新操作
                point.proceed();
                //记录审计日志
                if(beforeEntity!=null)
                    dataAuditService.updateAudit(request, beforeEntity , entity, null);
                return true;
            }
        }
        else if(serviceParam instanceof List && !ObjectUtils.isEmpty(serviceParam)) {
            List list=(List<?>) serviceParam;
            if(list.get(0) instanceof EntityBase) {
                EntityBase first = (EntityBase) list.get(0);
                BeanCache.BeanSchema schema = BeanCache.get(first.getClass());
                if(schema.isHasAudit()) {
                    String idField = schema.getKeyField().getCodeName();
                    if (ObjectUtils.isEmpty(idField)) {
                        return point.proceed();
                    }
                    List<EntityBase> beforeList = schema.getAudits().isEmpty()?list:getEntitys(serviceObj, list, first.getClass());
                    Map<Object, EntityBase> beforeMap = new LinkedHashMap<>();
                    beforeList.forEach(before -> {
                        beforeMap.put(before.get(idField), before);
                    });
                    point.proceed();
                    for (Object obj : list) {
                        EntityBase entity = (EntityBase) obj;
                        Object idValue = entity.get(idField);
                        EntityBase before = beforeMap.get(idValue);
                        if (before != null)
                            dataAuditService.updateAudit(request, before, entity, idValue);
                    }
                    return true;
                }
            }
        }
        return point.proceed();
    }

    /**
     * 实体数据更新切面，在成功更新数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * 使用环切【@Around】获取要删除的完整数据，并将审计属性相关信息记录到审计日志中
     * @param point
     * @return
     * @throws Throwable
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.*.remove(..))")
    @SneakyThrows
    public void remove(JoinPoint point) {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            request = ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return;
        }
        Object serviceParam = args[0];
        if(serviceParam instanceof EntityBase) {
            EntityBase entity = (EntityBase)serviceParam;
            //记录审计日志
            if(BeanCache.hasAudit(entity.getClass()))
                dataAuditService.removeAudit(request, entity, null);
        }
        else if(serviceParam instanceof List && !ObjectUtils.isEmpty(serviceParam)) {
            List list=(List<?>) serviceParam;
            if(list.get(0) instanceof EntityBase && BeanCache.hasAudit(list.get(0).getClass())) {
                for(Object entity:list)
                    dataAuditService.removeAudit(request, (EntityBase)entity, null);
            }
        }
    }

    /**
     * 获取实体
     * @param service
     * @param id
     * @return
     */
    @SneakyThrows
    private <T extends EntityBase> T getEntity(Object service, Object id, Class<T> clazz) {
        if(!ObjectUtils.isEmpty(service)) {
            EvaluationContext oldContext = new StandardEvaluationContext();
            oldContext.setVariable("service", service);
            oldContext.setVariable("id", id);
            Expression oldExp = parser.parseExpression("#service.get(#id)");
            return oldExp.getValue(oldContext, clazz);
        }
        return null;
    }

    @SneakyThrows
    private <T extends EntityBase> List<T> getEntitys(Object service, List<T> list, Class<T> clazz) {
        if(!ObjectUtils.isEmpty(service)) {
            EvaluationContext oldContext = new StandardEvaluationContext();
            oldContext.setVariable("service", service);
            oldContext.setVariable("list", list);
            Expression oldExp = parser.parseExpression("#service.getByEntities(#list)");
            return oldExp.getValue(oldContext, ArrayList.class);
        }
        return null;
    }
}