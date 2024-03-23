/**
 * Generate code from /{{projectName}}-{{apis}}/src/main/java/{{packageName}}/{{apis}}/rest/{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 实体[Favorite] rest实现
 *
 * @author generator
 */
@Slf4j
@io.swagger.annotations.Api(tags = {"收藏" })
@RestController("serviceapi-favorite")
@RequestMapping("${ibiz.rest.basePath.serviceapi:/}")
public class FavoriteResource extends FavoriteResourceImpl{

}
