/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.filter.PortfolioSearchContext;
import cn.ibizlab.plm.serviceapi.dto.PortfolioFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 文件夹转换过滤[PortfolioFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPortfolioFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PortfolioFilterDTOMapping extends MappingBase<PortfolioFilterDTO, PortfolioSearchContext> {

}
