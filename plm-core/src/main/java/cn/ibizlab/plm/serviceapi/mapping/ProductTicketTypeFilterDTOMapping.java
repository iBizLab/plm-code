/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProductTicketTypeFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 产品工单类型转换过滤[ProductTicketTypeFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProductTicketTypeFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductTicketTypeFilterDTOMapping extends MappingBase<ProductTicketTypeFilterDTO, ProductTicketTypeSearchContext> {

}
