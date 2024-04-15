/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/mapping/{{entities}}InheritMapping.java.hbs
 */
package cn.ibizlab.plm.core.projmgmt.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.base.domain.ReferencesIndex;
import java.util.List;

/**
 * 项目继承映射[Project]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProjectInheritMapping {

    /**
     * 转换ReferencesIndex
     * 
     * @param project
     * @return
     */
    @Mappings({
            @Mapping(target ="focusNull",ignore = true),
            @Mapping(source ="id",target = "id"),
            @Mapping(source ="name",target = "name"),
    })
    ReferencesIndex toReferencesIndex(Project project);

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
    Project toProject(ReferencesIndex referencesIndex);

    /**
     * List Project 对象转换
     *
     * @param list
     * @return
     */
    List<ReferencesIndex> toReferencesIndex(List<Project> list);

    /**
     * List ReferencesIndex 对象转换
     *
     * @param list
     * @return
     */
    List<Project> toProject(List<ReferencesIndex> list);

}
