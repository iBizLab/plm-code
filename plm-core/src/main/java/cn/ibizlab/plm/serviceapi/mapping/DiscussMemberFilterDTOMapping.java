/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.team.filter.DiscussMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.DiscussMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 协作成员转换过滤[DiscussMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIDiscussMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DiscussMemberFilterDTOMapping extends MappingBase<DiscussMemberFilterDTO, DiscussMemberSearchContext> {

}
