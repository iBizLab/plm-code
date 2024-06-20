/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.serviceapi.dto.InsightMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 效能成员转换[InsightMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIInsightMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface InsightMemberDTOMapping extends MappingBase<InsightMemberDTO, InsightMember> {


}
