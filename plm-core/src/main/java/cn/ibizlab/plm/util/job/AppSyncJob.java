/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/job/AppSyncJob.java.hbs
 */
package cn.ibizlab.plm.util.job;

import cn.ibizlab.util.client.UaaFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;

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


    @Value("${filefolder:/app/file/datafile}")
    private String modelCacheFolder;

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

        //fix： model's local cache can't refresh bug， Emergency plan needs to be improved
        try {
            File dirModelPath = Paths.get(modelCacheFolder,"deploysystem","e9e59a831e7290f9424d0b03e3017a97").toFile();
            if(dirModelPath.exists())
                FileUtils.deleteDirectory(dirModelPath);
            dirModelPath = Paths.get(modelCacheFolder,"ibizplm","deploysystem").toFile();
            if(dirModelPath.exists())
                FileUtils.deleteDirectory(dirModelPath);
            log.info("reset runtime model.");
        }catch (Exception e) {
            log.error("reset runtime model exception: {}", e.getMessage());
        }

    }
}