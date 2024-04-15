/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/aspect/DELogicAspect2.java.hbs
 */
package cn.ibizlab.plm.util.aspect;

import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.helper.BeanCache;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 实体处理逻辑切面（前后附加逻辑、实体行为调用处理逻辑）
 *
 * @author generator
 */
@Aspect
@Component
@Slf4j
@Order(100)
@ConditionalOnProperty(name = "ibiz.logic.type", havingValue = "Groovy", matchIfMissing = false)
public class DELogicAspect2 {

    /**
     * 执行实体行为附加逻辑、实体行为调用处理逻辑
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.ibizlab.plm.core.*.service.*.*(..)) && !execution(* cn.ibizlab.plm.core.es.service.*.*(..))")
    public Object executeLogic(ProceedingJoinPoint point) throws Throwable {
        Object args[] = point.getArgs();
        if (ObjectUtils.isEmpty(args) || args.length == 0) {
            return point.proceed();
        }
        Object service = point.getTarget();
        Object arg = args[0];
        String action = point.getSignature().getName();
        EntityBase entity = null;
        if (("remove".equalsIgnoreCase(action) || "get".equalsIgnoreCase(action)) && (!(arg instanceof EntityBase))) {
            entity = getEntity(service.getClass());
            if (!ObjectUtils.isEmpty(entity)) {
                String id = BeanCache.getKeyField(entity.getClass());
                if (StringUtils.isEmpty(id)) {
                    log.debug("无法获取实体主键属性[{}]", getEntityName(entity));
                    return point.proceed();
                }
                entity.set(id, arg);
            }
        } else if (arg instanceof EntityBase) {
            entity = (EntityBase) arg;
        }
        if (entity != null) {
            executeBeforeLogic(entity, action);
            Object result = point.proceed();
            if ("get".equalsIgnoreCase(action) && result instanceof EntityBase) {
                entity = (EntityBase) result;
            }
            Resource file = new ClassPathResource("logic" + File.separator + getEntityName(entity) + File.separator + pascalCase(action) + ".groovy");
            if (file != null && file.exists()) {
                result = executeLogic(entity, file);
            }
            executeAfterLogic(entity, action);
            return result;
        }
        if(true){
            System.out.println(11);
        }else if(arg.toString().equalsIgnoreCase("a")){
            System.out.println(11);
        }else{
            System.out.println(11);
        }
        return point.proceed();
    }

    /**
     * 判断类是否被代理类代理
     */
    private String getEntityName(Object entity) {
        String entityName = entity.getClass().getSimpleName();
        if (entityName.contains("$$")) {
            entityName = ClassUtils.getUserClass(entity.getClass()).getSimpleName();
        }
        return entityName;
    }

    /**
     * 前附加逻辑
     *
     * @param entity
     * @param action
     */
    private void executeBeforeLogic(EntityBase entity, String action) {

    }

    /**
     * 后附加逻辑
     *
     * @param entity
     * @param action
     */
    private void executeAfterLogic(EntityBase entity, String action) throws Exception {

    }

    /**
     * 实体行为调用处理逻辑
     *
     * @param entity
     * @param file
     */
    private Object executeLogic(EntityBase entity, Resource file) throws Exception {
        String strConfig = IOUtils.toString(file.getInputStream(), "UTF-8");
        GroovyClassLoader loader = new GroovyClassLoader();
        Class fileCreator = loader.parseClass(strConfig,file.getFilename());
        GroovyObject object = (GroovyObject) fileCreator.newInstance();
        return object.invokeMethod("execute", entity);
    }

    public static String pascalCase(String fieldName) {
        char[] chars = fieldName.toCharArray();
        chars[0] = toUpperCase(chars[0]);
        return String.valueOf(chars);
    }

    public static char toUpperCase(char c) {
        if (97 <= c && c <= 122) {
            c ^= 32;
        }
        return c;
    }


    /**
     * 获取实体
     *
     * @param service
     * @return
     */
    private EntityBase getEntity(Class service) {
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
            for (Class cls : method.getParameterTypes()) {
                try {
                    Object arg = cls.newInstance();
                    if (arg instanceof EntityBase) {
                        return (EntityBase) arg;
                    }
                } catch (Exception e) {
                }
            }
        }
        if (!ObjectUtils.isEmpty(service.getSuperclass()) && !service.getSuperclass().getName().equals(Object.class.getName())) {
            return getEntity(service.getSuperclass());
        }
        log.error("获取实体信息失败，未能在[{}]中找到参数为实体类对象的行为，如create.update等", service.getSimpleName());
        return null;
    }


    public enum LogicExecMode {
        /**
         * 前附加逻辑
         */
        BEFORE("0", "before"),
        /**
         * 后附加逻辑
         */
        AFTER("1", "after"),
        /**
         *
         */
        EXEC("2", "exec");

        LogicExecMode(String value, String text) {
            this.value = value;
            this.text = text;
        }

        private String value;
        private String text;
    }
}