/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import java.util.List;

/**
 * 测试库继承映射[Library]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {})
public interface LibraryInheritMapping {

    /**
     * 转换ReferencesIndex
     * 
     * @param library
     * @return
     */
    @Mappings({
            @Mapping(target ="focusNull",ignore = true),
            @Mapping(source ="id",target = "id"),
            @Mapping(source ="name",target = "name"),
    })
    ReferencesIndex toReferencesIndex(Library library);

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
    Library toLibrary(ReferencesIndex referencesIndex);

    /**
     * List Library 对象转换
     *
     * @param list
     * @return
     */
    List<ReferencesIndex> toReferencesIndex(List<Library> list);

    /**
     * List ReferencesIndex 对象转换
     *
     * @param list
     * @return
     */
    List<Library> toLibrary(List<ReferencesIndex> list);

}
