/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.base.domain.PortfolioMember;
import cn.ibizlab.plm.serviceapi.dto.PortfolioMemberDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 文件夹成员转换[PortfolioMemberDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPortfolioMemberDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PortfolioMemberDTOMapping extends MappingBase<PortfolioMemberDTO, PortfolioMember> {


}
