/**
 * Generate code from /{{projectName}}-{{apis}}/src/main/java/{{packageName}}/{{apis}}/rest/{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 实体[DictionaryData] rest实现
 *
 * @author generator
 */
@Slf4j
@io.swagger.annotations.Api(tags = {"数据字典" })
@RestController("serviceapi-dictionarydata")
@RequestMapping("${ibiz.rest.basePath.serviceapi:/}")
public class DictionaryDataResource extends DictionaryDataResourceImpl{

}
