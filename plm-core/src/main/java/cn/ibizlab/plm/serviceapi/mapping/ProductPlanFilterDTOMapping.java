/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProductPlanFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 排期转换过滤[ProductPlanFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProductPlanFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductPlanFilterDTOMapping extends MappingBase<ProductPlanFilterDTO, ProductPlanSearchContext> {

}
