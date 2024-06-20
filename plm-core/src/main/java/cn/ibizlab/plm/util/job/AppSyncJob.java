/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/job/AppSyncJob.java.hbs
 */
package cn.ibizlab.plm.util.job;

import cn.ibizlab.util.client.UaaFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 资源同步
 *
 * @author generator
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "ibiz.ref.service.rt.version", havingValue = "RT2")
public class AppSyncJob implements ApplicationRunner {

    @Autowired
    UaaFeignClient uaaFeignClient;


    @Value("${ibiz.ref.service.rt.sync.resourcepath:/permission/resource.json}")
    String resourcePath;

    @Override
    public void run(ApplicationArguments args) {

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            InputStream in = this.getClass().getResourceAsStream(resourcePath);
            if (!ObjectUtils.isEmpty(in)) {
                String resp = uaaFeignClient.deployResource("ibizplm", IOUtils.toByteArray(in));
                log.info(resp);
            } else {
                log.error("import SysDeploySystem failed, resource inputStream is null. resource path: {}", resourcePath);
            }
        } catch (Exception e) {
            log.error("import SysDeploySystem exception: {}", e.getMessage());
        }

    }
}