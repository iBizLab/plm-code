/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext;
import cn.ibizlab.plm.serviceapi.dto.CustomerFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 客户转换过滤[CustomerFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPICustomerFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerFilterDTOMapping extends MappingBase<CustomerFilterDTO, CustomerSearchContext> {

}
