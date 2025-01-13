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
import cn.ibizlab.plm.core.base.domain.Position;
import cn.ibizlab.plm.core.base.service.PositionService;
import cn.ibizlab.plm.core.base.filter.PositionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;
import reactor.core.publisher.Mono;

/**
 * 实体[Position] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractPositionResource {

    @Autowired
    public PositionService positionService;

    @Autowired
    @Lazy
    public PositionDTOMapping positionDtoMapping;

    @Autowired
    @Lazy
    public PositionFilterDTOMapping positionFilterDtoMapping;

    /**
    * 创建Create 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PositionDTO>>
    */
    @ApiOperation(value = "创建Create", tags = {"职位" },  notes = "Position-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-Create-all') or hasPermission(this.positionDtoMapping.toDomain(#dto),'ibizplm-Position-Create')")
    @PostMapping("positions")
    public Mono<ResponseEntity<ResponseWrapper<PositionDTO>>>create
            (@Validated @RequestBody RequestWrapper<PositionDTO> dto) {
        ResponseWrapper<PositionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 创建Create 职位
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PositionDTO>
    */   
    public PositionDTO create
            (PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        positionService.create(domain);
        Position rt = domain;
        return positionDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 职位
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<PositionDTO>>
    */
    @ApiOperation(value = "更新Update", tags = {"职位" },  notes = "Position-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-Update-all') or hasPermission(this.positionService.get(#id),'ibizplm-Position-Update')")
    @VersionCheck(entity = "position" , versionfield = "updateTime")
    @PutMapping("positions/{id}")
    public Mono<ResponseEntity<ResponseWrapper<PositionDTO>>>updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PositionDTO> dto) {
        ResponseWrapper<PositionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 更新Update 职位
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<PositionDTO>
    */   
    public PositionDTO updateById
            (String id, PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        domain.setId(id);
        positionService.update(domain);
        Position rt = domain;
        return positionDtoMapping.toDto(rt);
    }

    /**
    * move_order 职位
    * 
    *
    * @param id id
    * @param dto dto
    * @return Mono<ResponseEntity<List<PositionDTO>>>
    */
    @ApiOperation(value = "move_order", tags = {"职位" },  notes = "Position-move_order ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-move_order-all') or hasPermission(this.positionDtoMapping.toDomain(#dto),'ibizplm-Position-move_order')")
    @PostMapping("positions/{id}/move_order")
    public Mono<ResponseEntity<ResponseWrapper<List<PositionDTO>>>>moveOrderById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<PositionDTO> dto) {
        ResponseWrapper<List<PositionDTO>> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(moveOrderById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(moveOrderById(id, dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * move_order 职位
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<List<PositionDTO>>
    */   
    public List<PositionDTO> moveOrderById
            (String id, PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        domain.setId(id);
        List<Position> rt = positionService.moveOrder(domain);
        return positionDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PositionDTO>>
    */
    @ApiOperation(value = "保存Save", tags = {"职位" },  notes = "Position-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-Save-all') or hasPermission(this.positionDtoMapping.toDomain(#dto),'ibizplm-Position-Save')")
    @PostMapping("positions/save")
    public Mono<ResponseEntity<ResponseWrapper<PositionDTO>>>save
            (@Validated @RequestBody RequestWrapper<PositionDTO> dto) {
        ResponseWrapper<PositionDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 保存Save 职位
    * 
    *
    * @param dto dto
    * @return ResponseEntity<PositionDTO>
    */   
    public PositionDTO save
            (PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        positionService.save(domain);
        Position rt = domain;
        return positionDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 职位
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<PositionDTO>>
    */
    @ApiOperation(value = "获取Get", tags = {"职位" },  notes = "Position-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-Get-all')  or hasPermission(this.positionDtoMapping.toDomain(returnObject.block().getBody()),'ibizplm-Position-Get')")
    @GetMapping("positions/{id}")
    public Mono<ResponseEntity<PositionDTO>> getById
            (@PathVariable("id") String id) {
        Position rt = positionService.get(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(positionDtoMapping.toDto(rt)));
    }

    /**
    * 删除Remove 职位
    * 
    *
    * @param id id
    * @return Mono<ResponseEntity<Boolean>>
    */
    @ApiOperation(value = "删除Remove", tags = {"职位" },  notes = "Position-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-Remove-all') or hasPermission(this.positionService.get(#id),'ibizplm-Position-Remove')")
    @DeleteMapping("positions/{id}")
    public Mono<ResponseEntity<Boolean>> removeById
            (@PathVariable("id") String id) {
        Boolean rt = positionService.remove(id);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 校验CheckKey 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<Integer>>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"职位" },  notes = "Position-CheckKey ")
    @PostMapping("positions/check_key")
    public Mono<ResponseEntity<CheckKeyStatus>> checkKey
            (@Validated @RequestBody PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        CheckKeyStatus rt = positionService.checkKey(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(rt));
    }

    /**
    * 草稿GetDraft 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<PositionDTO>>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"职位" },  notes = "Position-GetDraft ")
    @GetMapping("positions/get_draft")
    public Mono<ResponseEntity<PositionDTO>> getDraft
            (@SpringQueryMap PositionDTO dto) {
        Position domain = positionDtoMapping.toDomain(dto);
        Position rt = positionService.getDraft(domain);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(positionDtoMapping.toDto(rt)));
    }

    /**
    * 查询fetch_default 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<PositionDTO>>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"职位" },  notes = "Position-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-fetch_default-all') or hasPermission(#dto,'ibizplm-Position-fetch_default')")
    @PostMapping("positions/fetch_default")
    public Mono<ResponseEntity<List<PositionDTO>>> fetchDefault
            (@Validated @RequestBody PositionFilterDTO dto) {
        PositionSearchContext context = positionFilterDtoMapping.toDomain(dto);
        Page<Position> domains = positionService.fetchDefault(context) ;
        List<PositionDTO> list = positionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }

    /**
    * 查询fetch_no_category 职位
    * 
    *
    * @param dto dto
    * @return Mono<ResponseEntity<List<PositionDTO>>>
    */
    @ApiOperation(value = "查询fetch_no_category", tags = {"职位" },  notes = "Position-fetch_no_category ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Position-fetch_no_category-all') or hasPermission(#dto,'ibizplm-Position-fetch_no_category')")
    @PostMapping("positions/fetch_no_category")
    public Mono<ResponseEntity<List<PositionDTO>>> fetchNoCategory
            (@Validated @RequestBody PositionFilterDTO dto) {
        PositionSearchContext context = positionFilterDtoMapping.toDomain(dto);
        Page<Position> domains = positionService.fetchNoCategory(context) ;
        List<PositionDTO> list = positionDtoMapping.toDto(domains.getContent());
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list));
    }


    /**
    * 批量新建职位
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Position-Create-all')")
    @ApiOperation(value = "批量新建职位", tags = {"职位" },  notes = "批量新建职位")
	@PostMapping("positions/batch")
    public Mono<ResponseEntity<Boolean>> createBatch(@RequestBody List<PositionDTO> dtos) {
        positionService.create(positionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量删除职位
    * @param ids ids
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Position-Remove-all')")
    @ApiOperation(value = "批量删除职位", tags = {"职位" },  notes = "批量删除职位")
	@DeleteMapping("positions/batch")
    public Mono<ResponseEntity<Boolean>> removeBatch(@RequestBody List<String> ids) {
        positionService.remove(ids);
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量更新职位
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Position-Update-all')")
    @ApiOperation(value = "批量更新职位", tags = {"职位" },  notes = "批量更新职位")
	@PutMapping("positions/batch")
    public Mono<ResponseEntity<Boolean>> updateBatch(@RequestBody List<PositionDTO> dtos) {
        positionService.update(positionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量保存职位
    * @param dtos
    * @return Mono<ResponseEntity<Boolean>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Position-Save-all')")
    @ApiOperation(value = "批量保存职位", tags = {"职位" },  notes = "批量保存职位")
	@PostMapping("positions/savebatch")
    public Mono<ResponseEntity<Boolean>> saveBatch(@RequestBody List<PositionDTO> dtos) {
        positionService.save(positionDtoMapping.toDomain(dtos));
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(true));
    }

    /**
    * 批量导入职位
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return Mono<ResponseEntity<ImportResult>>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Position-Save-all')")
    @ApiOperation(value = "批量导入职位", tags = {"职位" },  notes = "批量导入职位")
	@PostMapping("positions/import")
    public Mono<ResponseEntity<ImportResult>> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<PositionDTO> dtos) {
        return  Mono.just(ResponseEntity.status(HttpStatus.OK).body(positionService.importData(config,ignoreError,positionDtoMapping.toDomain(dtos))));
    }

}
