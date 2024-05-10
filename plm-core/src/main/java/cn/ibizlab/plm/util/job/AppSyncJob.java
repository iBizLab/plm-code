/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/job/AppSyncJob.java.hbs
 */
package cn.ibizlab.plm.util.job;

import cn.ibizlab.util.client.UaaFeignClient;
import cn.ibizlab.util.client.FlowFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
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

    @Autowired
    FlowFeignClient flowFeignClient;

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

        try {
            File dirModelPath = Paths.get(modelCacheFolder,"deploysystem").toFile();
            if(dirModelPath.exists())
                FileUtils.deleteDirectory(dirModelPath);
            dirModelPath = Paths.get(modelCacheFolder,"ibizplm","deploysystem").toFile();
            if(dirModelPath.exists())
                FileUtils.deleteDirectory(dirModelPath);
            log.info("reset runtime model.");
        }catch (Exception e) {
            log.error("reset runtime model exception: {}", e.getMessage());
        }

        try {
            LinkedHashMap<String, byte[]> workflows=new LinkedHashMap<String, byte[]>();
            InputStream caseReviewFlowv1 = this.getClass().getResourceAsStream("/workflow/case_review_flowv1.bpmn");
            if (!ObjectUtils.isEmpty(caseReviewFlowv1))
                workflows.put("case_review_flowv1.bpmn", IOUtils.toByteArray(caseReviewFlowv1));
            if (workflows.size() > 0) {
                if (flowFeignClient.deployBpmn("ibizplm",workflows)) {
                    log.info("向[wf]部署流程成功");
                } else {
                    log.error("向[wf]部署流程失败");
                }
            }
        } catch (Exception ex) {
            log.error("deploy bpmn exception: {}", ex.getMessage());
        }

    }
}