/**
 * Generate code from /{{projectName}}-{{apis}}/src/main/java/{{packageName}}/{{apis}}/rest/{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 实体[AddonRoleMember] rest实现
 *
 * @author generator
 */
@Slf4j
@io.swagger.annotations.Api(tags = {"组件权限成员" })
@RestController("serviceapi-addonrolemember")
@RequestMapping("${ibiz.rest.basePath.serviceapi:/}")
public class AddonRoleMemberResource extends AddonRoleMemberResourceImpl{

}
