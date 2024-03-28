/**
 * Generate code from /{{projectName}}-{{apis}}/src/main/java/{{packageName}}/BootApplication.java.hbs
 */
package cn.ibizlab.plm;

import cn.ibizlab.util.web.SearchContextHandlerMethodArgumentResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.ibizlab.util","cn.ibizlab.plm"})
@SpringBootApplication(exclude = {
            com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure.class,
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
            org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration.class,
})
@ComponentScan(basePackages = {"cn.ibizlab.plm.util.config","cn.ibizlab.util","cn.ibizlab.plm"}
//        ,excludeFilters = {
//                @ComponentScan.Filter(type= org.springframework.context.annotation.FilterType.REGEX, pattern="cn.ibizlab.plm.xxx.rest.xxx"),
//        }
)
@Import({
        org.springframework.cloud.openfeign.FeignClientsConfiguration.class
})
@EnableAsync
@EnableScheduling
public class BootApplication extends WebMvcConfigurerAdapter {

    @Autowired
    SearchContextHandlerMethodArgumentResolver resolver;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(resolver);
    }
}