/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/config/MybatisAutoConfiguration.java.hbs
 */
package cn.ibizlab.plm.util.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis自动配置
 *
 * @author generator
 */
@Configuration
@ConditionalOnClass(MybatisConfiguration.class)
@ConditionalOnWebApplication
public class MybatisAutoConfiguration {

	
}