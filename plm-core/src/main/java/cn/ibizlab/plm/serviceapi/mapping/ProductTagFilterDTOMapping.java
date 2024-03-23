/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProductTagFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 产品标签转换过滤[ProductTagFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProductTagFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductTagFilterDTOMapping extends MappingBase<ProductTagFilterDTO, ProductTagSearchContext> {

}
