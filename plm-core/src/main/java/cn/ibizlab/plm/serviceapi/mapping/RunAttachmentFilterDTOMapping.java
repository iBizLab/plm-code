/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext;
import cn.ibizlab.plm.serviceapi.dto.RunAttachmentFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 执行用例结果附件转换过滤[RunAttachmentFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIRunAttachmentFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RunAttachmentFilterDTOMapping extends MappingBase<RunAttachmentFilterDTO, RunAttachmentSearchContext> {

}
