/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.testmgmt.domain.Guideline;
import cn.ibizlab.plm.serviceapi.dto.GuidelineDefGroupDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 流程准则转换[GuidelineDefGroupDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIGuidelineDefGroupDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GuidelineDefGroupDTOMapping extends MappingBase<GuidelineDefGroupDTO, Guideline> {


}
