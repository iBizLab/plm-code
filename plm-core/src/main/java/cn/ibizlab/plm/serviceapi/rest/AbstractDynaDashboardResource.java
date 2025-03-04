/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/rest/Abstract{{apiEntities}}Resource.java.hbs
 */
package cn.ibizlab.plm.serviceapi.rest;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.ApiOperation;
import java.util.stream.IntStream;
import cn.ibizlab.util.domain.ImportResult;
import cn.ibizlab.util.domain.RequestWrapper;
import cn.ibizlab.util.domain.ResponseWrapper;
import cn.ibizlab.util.enums.CheckKeyStatus;
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.base.domain.DynaDashboard;
import cn.ibizlab.plm.core.base.service.DynaDashboardService;
import cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[DynaDashboard] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDynaDashboardResource {

    @Autowired
    public DynaDashboardService dynaDashboardService;

    @Autowired
    @Lazy
    public DynaDashboardDTOMapping dynaDashboardDtoMapping;

    @Autowired
    @Lazy
    public DynaDashboardExampleChartDTOMapping dynaDashboardExampleChartDtoMapping;

    @Autowired
    @Lazy
    public DynaDashboardFilterDTOMapping dynaDashboardFilterDtoMapping;

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"动态数据看板" },  notes = "DynaDashboard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Create-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Create')")
    @PostMapping("dyna_dashboards")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>create
            (@Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO create
            (DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        dynaDashboardService.create(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"动态数据看板" },  notes = "DynaDashboard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Update-all') or hasPermission(this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Update')")
    @VersionCheck(entity = "dynadashboard" , versionfield = "updateTime")
    @PutMapping("dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>updateByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByDynaDashboardId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByDynaDashboardId(dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO updateByDynaDashboardId
            (String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        dynaDashboardService.update(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * fill_other_board 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "fill_other_board", tags = {"动态数据看板" },  notes = "DynaDashboard-fill_other_board ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fill_other_board-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-fill_other_board')")
    @PostMapping("dyna_dashboards/{dynaDashboardId}/fill_other_board")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>fillOtherBoardByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillOtherBoardByDynaDashboardId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillOtherBoardByDynaDashboardId(dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_other_board 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO fillOtherBoardByDynaDashboardId
            (String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        DynaDashboard rt = dynaDashboardService.fillOtherBoard(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * move_order 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"动态数据看板" },  notes = "DynaDashboard-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-move_order-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-move_order')")
    @PostMapping("dyna_dashboards/{dynaDashboardId}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<DynaDashboardDTO>>>>moveOrderByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<List<DynaDashboardDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByDynaDashboardId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByDynaDashboardId(dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<List<DynaDashboardDTO>>
    */   
    public List<DynaDashboardDTO> moveOrderByDynaDashboardId
            (String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        List<DynaDashboard> rt = dynaDashboardService.moveOrder(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"动态数据看板" },  notes = "DynaDashboard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Save-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Save')")
    @PostMapping("dyna_dashboards/save")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>save
            (@Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO save
            (DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        dynaDashboardService.save(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * use_cur_template 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "use_cur_template", tags = {"动态数据看板" },  notes = "DynaDashboard-use_cur_template ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-use_cur_template-all') or hasPermission(this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-use_cur_template')")
    @PostMapping("dyna_dashboards/{dynaDashboardId}/use_cur_template")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>useCurTemplateByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(useCurTemplateByDynaDashboardId(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(useCurTemplateByDynaDashboardId(dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * use_cur_template 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO useCurTemplateByDynaDashboardId
            (String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        DynaDashboard rt = dynaDashboardService.useCurTemplate(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"动态数据看板" },  notes = "DynaDashboard-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Create-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Create')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO createByOwnerId
            (String ownerId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        dynaDashboardService.create(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"动态数据看板" },  notes = "DynaDashboard-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Update-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Update')")
    @VersionCheck(entity = "dynadashboard" , versionfield = "updateTime")
    @PutMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>updateByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndDynaDashboardId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndDynaDashboardId(ownerId, dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO updateByOwnerIdAndDynaDashboardId
            (String ownerId, String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        dynaDashboardService.update(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * fill_other_board 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "fill_other_board", tags = {"动态数据看板" },  notes = "DynaDashboard-fill_other_board ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fill_other_board-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-fill_other_board')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}/fill_other_board")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>fillOtherBoardByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(fillOtherBoardByOwnerIdAndDynaDashboardId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(fillOtherBoardByOwnerIdAndDynaDashboardId(ownerId, dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * fill_other_board 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO fillOtherBoardByOwnerIdAndDynaDashboardId
            (String ownerId, String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        DynaDashboard rt = dynaDashboardService.fillOtherBoard(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * move_order 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"动态数据看板" },  notes = "DynaDashboard-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-move_order-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-move_order')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<DynaDashboardDTO>>>>moveOrderByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<List<DynaDashboardDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderByOwnerIdAndDynaDashboardId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderByOwnerIdAndDynaDashboardId(ownerId, dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<List<DynaDashboardDTO>>
    */   
    public List<DynaDashboardDTO> moveOrderByOwnerIdAndDynaDashboardId
            (String ownerId, String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        List<DynaDashboard> rt = dynaDashboardService.moveOrder(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"动态数据看板" },  notes = "DynaDashboard-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Save-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-Save')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/save")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO saveByOwnerId
            (String ownerId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        dynaDashboardService.save(domain);
        DynaDashboard rt = domain;
        return dynaDashboardDtoMapping.toDto(rt);
    }

    /**
    * use_cur_template 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "use_cur_template", tags = {"动态数据看板" },  notes = "DynaDashboard-use_cur_template ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-use_cur_template-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(#dto),'ibizplm-DynaDashboard-use_cur_template')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}/use_cur_template")
    public Mono<ResponseEntity<ResponseWrapper<DynaDashboardDTO>>>useCurTemplateByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId, @Validated @RequestBody RequestWrapper<DynaDashboardDTO> dto) {
        ResponseWrapper<DynaDashboardDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = dynaDashboardId.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(useCurTemplateByOwnerIdAndDynaDashboardId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(useCurTemplateByOwnerIdAndDynaDashboardId(ownerId, dynaDashboardId, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * use_cur_template 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @param dto dto
    * @return ResponseEntity<DynaDashboardDTO>
    */   
    public DynaDashboardDTO useCurTemplateByOwnerIdAndDynaDashboardId
            (String ownerId, String dynaDashboardId, DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setDynaDashboardId(dynaDashboardId);
        DynaDashboard rt = dynaDashboardService.useCurTemplate(domain);
        return dynaDashboardDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"动态数据看板" },  notes = "DynaDashboard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Get-all')  or hasPermission(this.dynaDashboardDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DynaDashboard-Get')")
    @GetMapping("dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<DynaDashboardDTO>> getByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        DynaDashboard rt = dynaDashboardService.get(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"动态数据看板" },  notes = "DynaDashboard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Remove-all') or hasPermission(this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Remove')")
    @DeleteMapping("dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<Boolean>> removeByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        Boolean rt = dynaDashboardService.remove(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"动态数据看板" },  notes = "DynaDashboard-CheckKey ")
    @PostMapping("dyna_dashboards/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        CheckKeyStatus rt = dynaDashboardService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"动态数据看板" },  notes = "DynaDashboard-GetDraft ")
    @GetMapping("dyna_dashboards/get_draft")
    public Mono<ResponseEntity<DynaDashboardDTO>> getDraft
            (@SpringQueryMap DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        DynaDashboard rt = dynaDashboardService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * only_get 动态数据看板
    * 
    *
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "only_get", tags = {"动态数据看板" },  notes = "DynaDashboard-only_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-only_get-all') or hasPermission(this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-only_get')")
    @GetMapping("dyna_dashboards/{dynaDashboardId}/only_get")
    public Mono<ResponseEntity<DynaDashboardDTO>> onlyGetByDynaDashboardId
            (@PathVariable("dynaDashboardId") String dynaDashboardId) {
        DynaDashboard rt = dynaDashboardService.onlyGet(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_default-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_default')")
    @PostMapping("dyna_dashboards/fetch_default")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchDefault
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchDefault(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_example_chart 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardExampleChartDTO>>>
    */
    @ApiOperation(value = "查询fetch_example_chart", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_example_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_example_chart-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_example_chart')")
    @PostMapping("dyna_dashboards/fetch_example_chart")
    public Mono<ResponseEntity<List<DynaDashboardExampleChartDTO>>> fetchExampleChart
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchExampleChart(context) ;
        List<DynaDashboardExampleChartDTO> list = dynaDashboardExampleChartDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_system 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_system", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_is_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_is_system-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_is_system')")
    @PostMapping("dyna_dashboards/fetch_is_system")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchIsSystem
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchIsSystem(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_dashboard 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_dashboard", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_my_dashboard ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_my_dashboard-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_my_dashboard')")
    @PostMapping("dyna_dashboards/fetch_my_dashboard")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchMyDashboard
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchMyDashboard(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 动态数据看板
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_normal-all') or hasPermission(#dto,'ibizplm-DynaDashboard-fetch_normal')")
    @PostMapping("dyna_dashboards/fetch_normal")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchNormal
            (@Validated @RequestBody DynaDashboardFilterDTO dto) {
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchNormal(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 获取Get 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"动态数据看板" },  notes = "DynaDashboard-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Get-all')  or hasPermission('insight_view',#ownerId,this.dynaDashboardDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-DynaDashboard-Get')")
    @GetMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<DynaDashboardDTO>> getByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId) {
        DynaDashboard rt = dynaDashboardService.get(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"动态数据看板" },  notes = "DynaDashboard-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-Remove-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-Remove')")
    @DeleteMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}")
    public Mono<ResponseEntity<Boolean>> removeByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId) {
        Boolean rt = dynaDashboardService.remove(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"动态数据看板" },  notes = "DynaDashboard-CheckKey ")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        CheckKeyStatus rt = dynaDashboardService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"动态数据看板" },  notes = "DynaDashboard-GetDraft ")
    @GetMapping("insight_views/{ownerId}/dyna_dashboards/get_draft")
    public Mono<ResponseEntity<DynaDashboardDTO>> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap DynaDashboardDTO dto) {
        DynaDashboard domain = dynaDashboardDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        DynaDashboard rt = dynaDashboardService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * only_get 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dynaDashboardId dynaDashboardId
    * @return Mono<ResponseEntity<DynaDashboardDTO>>
    */
    @ApiOperation(value = "only_get", tags = {"动态数据看板" },  notes = "DynaDashboard-only_get ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-only_get-all') or hasPermission('insight_view',#ownerId,this.dynaDashboardService.get(#dynaDashboardId),'ibizplm-DynaDashboard-only_get')")
    @GetMapping("insight_views/{ownerId}/dyna_dashboards/{dynaDashboardId}/only_get")
    public Mono<ResponseEntity<DynaDashboardDTO>> onlyGetByOwnerIdAndDynaDashboardId
            (@PathVariable("ownerId") String ownerId, @PathVariable("dynaDashboardId") String dynaDashboardId) {
        DynaDashboard rt = dynaDashboardService.onlyGet(dynaDashboardId);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_default-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-DynaDashboard-fetch_default')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/fetch_default")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchDefault(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_example_chart 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardExampleChartDTO>>>
    */
    @ApiOperation(value = "查询fetch_example_chart", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_example_chart ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_example_chart-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-DynaDashboard-fetch_example_chart')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/fetch_example_chart")
    public Mono<ResponseEntity<List<DynaDashboardExampleChartDTO>>> fetchExampleChartByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchExampleChart(context) ;
        List<DynaDashboardExampleChartDTO> list = dynaDashboardExampleChartDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_is_system 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_is_system", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_is_system ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_is_system-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-DynaDashboard-fetch_is_system')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/fetch_is_system")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchIsSystemByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchIsSystem(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_my_dashboard 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_my_dashboard", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_my_dashboard ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_my_dashboard-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-DynaDashboard-fetch_my_dashboard')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/fetch_my_dashboard")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchMyDashboardByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchMyDashboard(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_normal 动态数据看板
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return Mono<ResponseEntity<List<DynaDashboardDTO>>>
    */
    @ApiOperation(value = "查询fetch_normal", tags = {"动态数据看板" },  notes = "DynaDashboard-fetch_normal ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-DynaDashboard-fetch_normal-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-DynaDashboard-fetch_normal')")
    @PostMapping("insight_views/{ownerId}/dyna_dashboards/fetch_normal")
    public Mono<ResponseEntity<List<DynaDashboardDTO>>> fetchNormalByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody DynaDashboardFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        DynaDashboardSearchContext context = dynaDashboardFilterDtoMapping.toDomain(dto);
        Page<DynaDashboard> domains = dynaDashboardService.fetchNormal(context) ;
        List<DynaDashboardDTO> list = dynaDashboardDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建动态数据看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Create-all')")
    @ApiOperation(value = "批量新建动态数据看板", tags = {"动态数据看板" },  notes = "批量新建动态数据看板")
	@PostMapping("dyna_dashboards/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.create(dynaDashboardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除动态数据看板
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Remove-all')")
    @ApiOperation(value = "批量删除动态数据看板", tags = {"动态数据看板" },  notes = "批量删除动态数据看板")
	@DeleteMapping("dyna_dashboards/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        dynaDashboardService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新动态数据看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Update-all')")
    @ApiOperation(value = "批量更新动态数据看板", tags = {"动态数据看板" },  notes = "批量更新动态数据看板")
	@PutMapping("dyna_dashboards/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.update(dynaDashboardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存动态数据看板
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Save-all')")
    @ApiOperation(value = "批量保存动态数据看板", tags = {"动态数据看板" },  notes = "批量保存动态数据看板")
	@PostMapping("dyna_dashboards/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<DynaDashboardDTO> dtos) {
        dynaDashboardService.save(dynaDashboardDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入动态数据看板
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-DynaDashboard-Save-all')")
    @ApiOperation(value = "批量导入动态数据看板", tags = {"动态数据看板" },  notes = "批量导入动态数据看板")
	@PostMapping("dyna_dashboards/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<DynaDashboardDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(dynaDashboardService.importData(config,ignoreError,dynaDashboardDtoMapping.toDomain(dtos))));
    }

}
