/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.prodmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import java.util.List;

/**
 * 产品继承映射[Product]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductInheritMapping {

    /**
     * 转换ReferencesIndex
     * 
     * @param product
     * @return
     */
    @Mappings({
            @Mapping(target ="focusNull",ignore = true),
            @Mapping(source ="id",target = "id"),
            @Mapping(source ="name",target = "name"),
    })
    ReferencesIndex toReferencesIndex(Product product);

    /**
     * 转换ReferencesIndex
     * 
     * @param referencesIndex
     * @return
     */
    @Mappings({
            @Mapping(target ="focusNull",ignore = true),
            @Mapping(source ="id",target = "id"),
            @Mapping(source ="name",target = "name"),
    })
    Product toProduct(ReferencesIndex referencesIndex);

    /**
     * List Product 对象转换
     *
     * @param list
     * @return
     */
    List<ReferencesIndex> toReferencesIndex(List<Product> list);

    /**
     * List ReferencesIndex 对象转换
     *
     * @param list
     * @return
     */
    List<Product> toProduct(List<ReferencesIndex> list);

}
