/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.Portfolio;
import cn.ibizlab.plm.serviceapi.dto.PortfolioDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 文件夹转换[PortfolioDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPortfolioDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PortfolioDTOMapping extends MappingBase<PortfolioDTO, Portfolio> {


}
