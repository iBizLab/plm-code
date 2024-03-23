/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/mapping/{{apiDtos@DEFAULT}}Mapping.java.hbs
 */
package cn.ibizlab.plm.serviceapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.plm.core.extension.domain.PSDEMSLogic;
import cn.ibizlab.plm.serviceapi.dto.PSDEMSLogicDTO;
import cn.ibizlab.util.domain.MappingBase;

/**
 * 实体主状态迁移逻辑转换[PSDEMSLogicDTO]
 *
 * @author generator
 */
@Mapper(componentModel = "spring", uses = {}, implementationName = "ServiceAPIPSDEMSLogicDTOMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PSDEMSLogicDTOMapping extends MappingBase<PSDEMSLogicDTO, PSDEMSLogic> {


}
