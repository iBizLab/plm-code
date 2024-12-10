/**
 * Generate code from /{{projectName}}-{{apis}}/src/main/java/{{packageName}}/{{apis}}/rest/{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 实体[ProjectState] rest实现
 *
 * @author generator
 */
@Slf4j
@io.swagger.annotations.Api(tags = {"项目状态" })
@RestController("serviceapi-projectstate")
@RequestMapping("${ibiz.rest.basePath.serviceapi:/}")
public class ProjectStateResource extends ProjectStateResourceImpl{

}
