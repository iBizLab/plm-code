/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFILTER}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext;
import cn.ibizlab.plm.serviceapi.dto.ProductMemberFilterDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 产品成员转换过滤[ProductMemberFilterDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIProductMemberFilterDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMemberFilterDTOMapping extends MappingBase<ProductMemberFilterDTO, ProductMemberSearchContext> {

}
