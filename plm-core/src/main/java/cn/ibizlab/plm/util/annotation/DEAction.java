/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/annotation/DEAction.java.hbs
 */
package cn.ibizlab.plm.util.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DEAction{
    /**
     * 处理逻辑文件
     * @return
     */
    String file() default "";
    /**
     * 行为类型是处理时，展示关联处理逻辑名称
     * @return
     */
    String name() default "";
    /**
     * 前附加逻辑
     * @return
     */
    String prefix() default "";
    /**
     * 后附加逻辑
     * @return
     */
    String suffix() default "";
}