/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/aspect/VersionCheckAspect.java.hbs
 */
package cn.ibizlab.plm.util.aspect;

import lombok.SneakyThrows;
import cn.ibizlab.util.annotation.VersionCheck;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.RuleUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 数据库版本检查
 *
 * @author generator
 */
//@Aspect
//@Order(50)
//@Component
public class VersionCheckAspect
{
    private final ExpressionParser parser = new SpelExpressionParser();
    private final String IgnoreField = "ignoreversioncheck";

    @SneakyThrows
    @Before("execution(* cn.ibizlab.plm.*.rest.*.update(..)) &&  @annotation(versionCheck)")
    public void BeforeUpdate(JoinPoint point, VersionCheck versionCheck) {
        Object[] args = point.getArgs();
        Object id = args[0];
        Object dto = args[1];
        if(ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(dto)) {
            return;
        }
        String versionField = versionCheck.versionfield();
        if(StringUtils.isEmpty(versionField)) {
            return;
        }
        versionCheck(versionCheck,point.getTarget(), dto, id);
    }

    @SneakyThrows
    @Before("execution(* cn.ibizlab.plm.*.rest.*.updateBy*(..)) &&  @annotation(versionCheck)")
    public void BeforeUpdateBy(JoinPoint point, VersionCheck versionCheck) {
        Object[] args = point.getArgs();
        if(args.length>=2) {
            Object id = args[args.length-2];
            Object dto = args[args.length-1];
            if(ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(dto)) {
                return;
            }
            String versionField = versionCheck.versionfield();
            if(StringUtils.isEmpty(versionField)) {
                return;
            }
            versionCheck(versionCheck, point.getTarget(), dto, id);
        }
    }

    private void versionCheck(VersionCheck versionCheck, Object resource, Object dto, Object id) {
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("dto", dto);
        //忽略版本检查
        Expression dtoParamsExp = parser.parseExpression("#dto.extensionparams");
        Map dtoParam = dtoParamsExp.getValue(context, Map.class);
        if(!ObjectUtils.isEmpty(dtoParam) && !ObjectUtils.isEmpty(dtoParam.get(IgnoreField)) && dtoParam.get(IgnoreField).equals(1)) {
            return;
        }
        Expression newExp = parser.parseExpression(String.format("#dto.%s", versionCheck.versionfield()));
        Object newVersion = newExp.getValue(context);
        if(ObjectUtils.isEmpty(newVersion)) {
            return;
        }
        //进行版本检查
        Object oldVersion = getDBVersion(versionCheck,getService(resource, versionCheck.entity()), id);
        if(!ObjectUtils.isEmpty(oldVersion)) {
            if(RuleUtils.gt(newVersion, oldVersion)) {
                throw new BadRequestAlertException("数据已变更，可能后台数据已被修改，请重新加载数据", "VersionCheckAspect", "versionCheck");
            }
        }
    }

    /**
     * 获取实体服务对象
     * @param resource
     * @param entity
     * @return
     */
    @SneakyThrows
    private Object getService(Object resource, String entity) {
        Object service = null;
        Field[] fields = resource.getClass().getDeclaredFields();
        for(Field field : fields) {
            if(field.getModifiers()==1 && field.getName().equalsIgnoreCase(String.format("%sService",entity))) {
                service = field.get(resource);
                break;
            }
        }
        return service;
    }

    /**
     * 获取数据库版本
     * @param versionCheck
     * @param service
     * @param id
     * @return
     */
    @SneakyThrows
    private Object getDBVersion(VersionCheck versionCheck, Object service, Object id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp dbVersion = null;
        String versionField = versionCheck.versionfield();
        if(!ObjectUtils.isEmpty(service)) {
            EvaluationContext oldContext = new StandardEvaluationContext();
            oldContext.setVariable("service", service);
            oldContext.setVariable("id", id);
            Expression oldExp = parser.parseExpression("#service.get(#id)");
            EntityBase oldEntity = oldExp.getValue(oldContext, EntityBase.class);
            Object oldDate = oldEntity.get(versionField);
            if(oldDate!=null && oldDate instanceof Timestamp) {
                Timestamp db_time = (Timestamp) oldDate;
                Date db_date = sdf.parse(sdf.format(db_time));
                dbVersion = new Timestamp(db_date.getTime());
            }
        }
        return dbVersion;
    }
}