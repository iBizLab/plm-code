/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/aspect/DEFieldDefaultValueAspect.java.hbs
 */
package cn.ibizlab.plm.util.aspect;

import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.enums.DEFieldDefaultValueType;
import cn.ibizlab.util.enums.DEPredefinedFieldType;
import cn.ibizlab.util.helper.BeanCache;
import cn.ibizlab.util.security.AuthenticationUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.ObjectUtils;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 实体属性默认值切面，只有新建（Create）时才会填充默认值
 *
 * @author generator
 */
@Aspect
@Order(50)
@Component
public class DEFieldDefaultValueAspect
{
    /**
     * 操作用户标识
     */
    final static String TAG_PERSONID = "SRF_PERSONID";

    /**
     * 操作用户名称
     */
    final static String TAG_PERSONNAME = "SRF_PERSONNAME";

    /**
     * 新建数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.create(..))")
    public void BeforeCreate(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.createBatch(..))")
    public void BeforeCreateBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 更新数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.update(..))")
    public void BeforeUpdate(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.updateBatch(..))")
    public void BeforeUpdateBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 保存数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.save(..))")
    public void BeforeSave(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.plm.core.*.service.*.saveBatch(..))")
    public void BeforeSaveBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 填充属性默认值
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public Object fillDEFieldDefaultValue(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            String actionName = joinPoint.getSignature().getName();
            if(obj instanceof EntityBase) {
                AuthenticationUser curUser = AuthenticationUser.getAuthenticationUser();
                String keyField = BeanCache.getKeyField(obj.getClass());
                if(ObjectUtils.isEmpty(keyField)) {
                    return true;
                }
                fillDEField((EntityBase)obj, BeanCache.get(obj.getClass()).getDeFields(), actionName, curUser, keyField);
            }
            else if (obj instanceof List) {
                List<BeanCache.FieldItem> deFields = null;
                AuthenticationUser curUser = null;
                String keyField = "";
                for(Object item : (List)obj) {
                    if(item instanceof EntityBase) {
                        if(deFields == null) {
                            deFields = BeanCache.get(item.getClass()).getDeFields();
                            curUser = AuthenticationUser.getAuthenticationUser();
                            keyField = BeanCache.getKeyField(item.getClass());
                            if(ObjectUtils.isEmpty(keyField)) {
                                return true;
                            }
                        }
                        fillDEField((EntityBase)item, deFields, actionName, curUser, keyField);
                    }
                }
            }
        }
        return true;
    }



    /**
     * 填充系统预置属性
     * @param et   当前实体对象
     */
    private void fillDEField(EntityBase et, List<BeanCache.FieldItem> deFields, String actionName, AuthenticationUser curUser, String keyField) throws Exception {
        if(deFields.size()==0) {
            return;
        }
        if(actionName.toLowerCase().startsWith("save")) {
            if(ObjectUtils.isEmpty(et.get(keyField))) {
                actionName="create";
            }
        }
        for (BeanCache.FieldItem item : deFields) {
            String fieldname=item.getCodeName();
            //获取注解
            DEField fieldAnnotation=item.getDeField();
            //获取默认值类型
            DEFieldDefaultValueType deFieldType=fieldAnnotation.defaultValueType();
            //获取属性默认值
            String deFieldDefaultValue = fieldAnnotation.defaultValue();
            //获取预置属性类型
            DEPredefinedFieldType predefinedFieldType = fieldAnnotation.preType();

            //填充系统默认值
            if(actionName.toLowerCase().startsWith("create") && (deFieldType!= DEFieldDefaultValueType.NONE  ||  (!ObjectUtils.isEmpty(deFieldDefaultValue)))) {
                fillFieldDefaultValue(fieldname,  deFieldType,  deFieldDefaultValue,  et , curUser) ;
            }
            //填充系统预置属性
            if(predefinedFieldType != DEPredefinedFieldType.NONE) {
                fillPreFieldValue(fieldname, predefinedFieldType , et ,actionName ,fieldAnnotation.logicval(),curUser);
            }
        }
    }

    /**
     * 填充属性默认值
     * @param fieldname 实体属性名
     * @param deFieldType 默认值类型
     * @param deFieldDefaultValue 默认值
     * @param et 当前实体对象
     * @throws Exception
     */
    private void fillFieldDefaultValue(String fieldname, DEFieldDefaultValueType deFieldType, String deFieldDefaultValue, EntityBase et , AuthenticationUser curUser) throws Exception {
        Object fieldValue = et.get(fieldname);
        if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)) {
            //填充直接值及其余默认值类型
            if( (deFieldType== DEFieldDefaultValueType.NONE && !ObjectUtils.isEmpty(deFieldDefaultValue)) || (deFieldType != DEFieldDefaultValueType.NONE)) {
                switch(deFieldType) {
                    case SESSION:
                        if(!ObjectUtils.isEmpty(deFieldDefaultValue)) {
                            Object sessionFieldValue = curUser.getSessionParams().get(deFieldDefaultValue.toLowerCase());
                            if(!ObjectUtils.isEmpty(sessionFieldValue)) {
                                et.set(fieldname, sessionFieldValue);
                            }
                        }
                        break;
                    case APPLICATION:
                        //暂未实现
                        break;
                    case UNIQUEID:
                        et.set(fieldname, (new AlternativeJdkIdGenerator()).generateId().toString().replace("-", ""));
                        break;
                    case CONTEXT:
                        if(!ObjectUtils.isEmpty(deFieldDefaultValue)) {
                            Object paramFieldValue=et.get(deFieldDefaultValue);
                            if(!ObjectUtils.isEmpty(paramFieldValue)) {
                                et.set(fieldname, paramFieldValue);
                            }
                        }
                        break;
                    case PARAM:
                        if(!ObjectUtils.isEmpty(deFieldDefaultValue)) {
                            Object paramFieldValue=et.get(deFieldDefaultValue);
                            if(!ObjectUtils.isEmpty(paramFieldValue)) {
                                et.set(fieldname, paramFieldValue);
                            }
                        }
                        break;
                    case OPERATOR:
                        et.set(fieldname, curUser.getUserid());
                        break;
                    case OPERATORNAME:
                        et.set(fieldname, curUser.getPersonName());
                        break;
                    case CURTIME:
                        et.set(fieldname, new Timestamp(new Date().getTime()));
                        break;
                    case APPDATA:
                        //暂未实现
                        break;
                    case NONE:
                        et.set(fieldname, deFieldDefaultValue);
                        break;
                }
            }
        }
    }

    private void fillPreFieldValue(String fieldname, DEPredefinedFieldType preFieldType, EntityBase et, String actionName, String logicValue, AuthenticationUser curUser) throws Exception {
        Object fieldValue = et.get(fieldname);
        //为预置属性进行赋值
        if(actionName.toLowerCase().startsWith("create") ||
                preFieldType== DEPredefinedFieldType.UPDATEDATE|| preFieldType== DEPredefinedFieldType.UPDATEMAN||
                preFieldType== DEPredefinedFieldType.UPDATEMANNAME) {

            switch(preFieldType) {
                case CREATEMAN:
                    et.set(fieldname, ObjectUtils.isEmpty(curUser.getUserid()) ? et.get(TAG_PERSONID) : curUser.getUserid());
                    break;
                case CREATEMANNAME:
                    et.set(fieldname, ObjectUtils.isEmpty(curUser.getPersonName()) ? et.get(TAG_PERSONNAME) : curUser.getPersonName());
                    break;
                case UPDATEMAN:
                    et.set(fieldname, ObjectUtils.isEmpty(curUser.getUserid()) ? et.get(TAG_PERSONID) : curUser.getUserid());
                    break;
                case UPDATEMANNAME:
                    et.set(fieldname, ObjectUtils.isEmpty(curUser.getPersonName()) ? et.get(TAG_PERSONNAME) : curUser.getPersonName());
                    break;
                case CREATEDATE:
                    et.set(fieldname, new Timestamp(new Date().getTime()));
                    break;
                case UPDATEDATE:
                    et.set(fieldname, new Timestamp(new Date().getTime()));
                    break;
                case ORGID:
                    if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)) {
                        et.set(fieldname, curUser.getOrganizationId());
                    }
                    break;
                case ORGNAME:
                    if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)) {
                        et.set(fieldname, curUser.getOrganizationName());
                    }
                    break;
                case ORGSECTORID:
                    if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)) {
                        et.set(fieldname, curUser.getDepartmentId());
                    }
                    break;
                case ORGSECTORNAME:
                    if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)) {
                        et.set(fieldname, curUser.getDepartmentName());
                    }
                    break;
                case LOGICVALID:
                    if(ObjectUtils.isEmpty(logicValue)) {
                        logicValue="1";
                    }
                    et.set(fieldname, logicValue);
                    break;
            }
        }
    }

}