/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.PortfolioMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 文件夹成员转换过滤[PortfolioMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPortfolioMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PortfolioMemberFilterDTOMapping extends MappingBase<PortfolioMemberFilterDTO, PortfolioMemberSearchContext> {

}
