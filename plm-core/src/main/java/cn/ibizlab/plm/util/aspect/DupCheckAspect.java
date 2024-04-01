/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/aspect/DupCheckAspect.java.hbs
 */
package cn.ibizlab.plm.util.aspect;

import cn.ibizlab.util.helper.BeanCache;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.enums.DupCheck;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.filter.QueryFilter;
import cn.ibizlab.util.filter.SearchContextBase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.domain.Page;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.util.Map;

/**
 * 属性重复值检查切面
 *
 * @author generator
 */
@Aspect
@Component
@Slf4j
public class DupCheckAspect {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * 实体[ArticlePage]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.ArticlePageService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.ArticlePageService.update*(..))")
    public void checkArticlePage(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Idea]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.IdeaService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.IdeaService.update*(..))")
    public void checkIdea(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Library]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.LibraryService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.LibraryService.update*(..))")
    public void checkLibrary(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Portfolio]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.PortfolioService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.PortfolioService.update*(..))")
    public void checkPortfolio(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Product]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.ProductService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.ProductService.update*(..))")
    public void checkProduct(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Project]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.ProjectService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.ProjectService.update*(..))")
    public void checkProject(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Space]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.SpaceService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.SpaceService.update*(..))")
    public void checkSpace(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[TestCase]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.TestCaseService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.TestCaseService.update*(..))")
    public void checkTestCase(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Ticket]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.TicketService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.TicketService.update*(..))")
    public void checkTicket(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[Version]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.VersionService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.VersionService.update*(..))")
    public void checkVersion(JoinPoint point) {
        check(point, "searchDefault");
    }
    /**
     * 实体[WorkItem]
     *
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.plm.core.*.service.WorkItemService.create*(..))||execution(* cn.ibizlab.plm.core.*.service.WorkItemService.update*(..))")
    public void checkWorkItem(JoinPoint point) {
        check(point, "searchDefault");
    }


    /**
     * 实体属性重复值检查
     * @param point 切点
     * @param defaultDS 实体默认数据集名称
     */
    private void check(JoinPoint point, String defaultDS) {
        Object[] args = point.getArgs();
        if (args.length > 0) {
            Object entity = args[0];
            Object service = point.getTarget();


            BeanCache.get(entity.getClass()).getDeFields().forEach(item->{
                String fieldName = item.getFieldName();
                DEField fieldAnnotation = item.getDeField();
                DupCheck dupCheck = fieldAnnotation.dupCheck();
                String dupCheckField=fieldAnnotation.dupCheckField();
                if (dupCheck == DupCheck.ALL) {
                    Object newValue =getDEFieldValue(entity,fieldName);
                    //获取searchContext
                    EvaluationContext searchContextCtx = new StandardEvaluationContext();
                    searchContextCtx.setVariable("service", service);
                    Expression searchContextExp = parser.parseExpression("#service.getSearchContext()");
                    SearchContextBase searchContext = searchContextExp.getValue(searchContextCtx, SearchContextBase.class);

                    //设置检查属性值
                    QueryFilter filter = new QueryFilter();
                    setValue(entity, filter, fieldName, newValue);

                    //设定重复值检查范围
                    if(!StringUtils.isEmpty(dupCheckField)) {
                        Object dupFieldValue=getDEFieldValue(entity,dupCheckField);
                        setValue(entity, filter, dupCheckField, dupFieldValue);
                    }
                    searchContext.setFilter(filter);
                    //使用当前值到数据库中进行查询，判断是否重复
                    EvaluationContext oldValueMappingCtx = new StandardEvaluationContext();
                    oldValueMappingCtx.setVariable("service", service);
                    oldValueMappingCtx.setVariable("searchContext", searchContext);
                    Expression oldValueMappingExp = parser.parseExpression(String.format("#service.%s(#searchContext)", defaultDS));
                    Page oldData = oldValueMappingExp.getValue(oldValueMappingCtx, Page.class);
                    if (!ObjectUtils.isEmpty(oldData) && !ObjectUtils.isEmpty(oldData.getContent()) && oldData.getContent().size() > 1) {
                        throw new BadRequestAlertException(String.format("数据保存失败，属性[%s]:值[%s]已存在!", fieldName, newValue), "DupCheckAspect", "DupCheck");
                    }
                }
            });
        }
    }

    /**
     * 获取实体属性值
     * @param entity
     * @param fieldName
     * @return
     */
    private Object getDEFieldValue(Object entity, String fieldName) {
        EvaluationContext exMappingCtx = new StandardEvaluationContext();
        exMappingCtx.setVariable("entity", entity);
        Expression esMappingExp = parser.parseExpression(String.format("#entity.get(\"%s\")", fieldName));
        return esMappingExp.getValue(exMappingCtx);
    }

    /**
     * 设置filter
     * @param entity
     * @param filter
     * @param value
     */
    private void setValue(Object entity , QueryFilter filter, String fieldName, Object value){
        if(ObjectUtils.isEmpty(value)) {
            filter.isnull(BeanCache.getFieldName(entity.getClass(), fieldName));
        }
        else {
            filter.eq(BeanCache.getFieldName(entity.getClass(), fieldName), value);
        }
    }
}