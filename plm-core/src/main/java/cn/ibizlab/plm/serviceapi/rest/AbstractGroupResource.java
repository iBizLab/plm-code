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
import cn.ibizlab.plm.serviceapi.dto.*;
import cn.ibizlab.plm.serviceapi.mapping.*;
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.service.GroupService;
import cn.ibizlab.plm.core.base.filter.GroupSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[Group] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractGroupResource {

    @Autowired
    public GroupService groupService;

    @Autowired
    @Lazy
    public GroupDTOMapping groupDtoMapping;

    @Autowired
    @Lazy
    public GroupFilterDTOMapping groupFilterDtoMapping;

    /**
    * 创建Create 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"团队" },  notes = "Group-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-Create-all') or hasPermission(this.groupDtoMapping.toDomain(#dto),'ibizplm-Group-Create')")
    @PostMapping("groups")
    public ResponseEntity<ResponseWrapper<GroupDTO>> create
            (@Validated @RequestBody RequestWrapper<GroupDTO> dto) {
        ResponseWrapper<GroupDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(create(item)));
        else
            rt.set(create(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */   
    public GroupDTO create
            (GroupDTO dto) {
        Group domain = groupDtoMapping.toDomain(dto);
        groupService.create(domain);
        Group rt = domain;
        return groupDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 团队
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"团队" },  notes = "Group-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-Update-all') or hasPermission(this.groupService.get(#id),'ibizplm-Group-Update')")
    @VersionCheck(entity = "group" , versionfield = "updateTime")
    @PutMapping("groups/{id}")
    public ResponseEntity<ResponseWrapper<GroupDTO>> updateById
            (@PathVariable("id") String id, @Validated @RequestBody RequestWrapper<GroupDTO> dto) {
        ResponseWrapper<GroupDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateById(ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateById(id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 团队
    * 
    *
    * @param id id
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */   
    public GroupDTO updateById
            (String id, GroupDTO dto) {
        Group domain = groupDtoMapping.toDomain(dto);
        domain.setId(id);
        groupService.update(domain);
        Group rt = domain;
        return groupDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"团队" },  notes = "Group-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-Save-all') or hasPermission(this.groupDtoMapping.toDomain(#dto),'ibizplm-Group-Save')")
    @PostMapping("groups/save")
    public ResponseEntity<ResponseWrapper<GroupDTO>> save
            (@Validated @RequestBody RequestWrapper<GroupDTO> dto) {
        ResponseWrapper<GroupDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(save(item)));
        else
            rt.set(save(dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */   
    public GroupDTO save
            (GroupDTO dto) {
        Group domain = groupDtoMapping.toDomain(dto);
        groupService.save(domain);
        Group rt = domain;
        return groupDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 团队
    * 
    *
    * @param id id
    * @return ResponseEntity<GroupDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"团队" },  notes = "Group-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-Get-all')  or hasPermission(this.groupDtoMapping.toDomain(returnObject.body),'ibizplm-Group-Get')")
    @GetMapping("groups/{id}")
    public ResponseEntity<GroupDTO> getById
            (@PathVariable("id") String id) {
        Group rt = groupService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(groupDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 团队
    * 
    *
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"团队" },  notes = "Group-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-Remove-all') or hasPermission(this.groupService.get(#id),'ibizplm-Group-Remove')")
    @DeleteMapping("groups/{id}")
    public ResponseEntity<Boolean> removeById
            (@PathVariable("id") String id) {
        Boolean rt = groupService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"团队" },  notes = "Group-CheckKey ")
    @PostMapping("groups/check_key")
    public ResponseEntity<Integer> checkKey
            (@Validated @RequestBody GroupDTO dto) {
        Group domain = groupDtoMapping.toDomain(dto);
        Integer rt = groupService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<GroupDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"团队" },  notes = "Group-GetDraft ")
    @GetMapping("groups/get_draft")
    public ResponseEntity<GroupDTO> getDraft
            (@SpringQueryMap GroupDTO dto) {
        Group domain = groupDtoMapping.toDomain(dto);
        Group rt = groupService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(groupDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<GroupDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"团队" },  notes = "Group-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-fetch_default-all') or hasPermission(#dto,'ibizplm-Group-fetch_default')")
    @PostMapping("groups/fetch_default")
    public ResponseEntity<List<GroupDTO>> fetchDefault
            (@Validated @RequestBody GroupFilterDTO dto) {
        GroupSearchContext context = groupFilterDtoMapping.toDomain(dto);
        Page<Group> domains = groupService.searchDefault(context) ;
        List<GroupDTO> list = groupDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_no_section 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<GroupDTO>>
    */
    @ApiOperation(value = "查询fetch_no_section", tags = {"团队" },  notes = "Group-fetch_no_section ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-fetch_no_section-all') or hasPermission(#dto,'ibizplm-Group-fetch_no_section')")
    @PostMapping("groups/fetch_no_section")
    public ResponseEntity<List<GroupDTO>> fetchNoSection
            (@Validated @RequestBody GroupFilterDTO dto) {
        GroupSearchContext context = groupFilterDtoMapping.toDomain(dto);
        Page<Group> domains = groupService.searchNoSection(context) ;
        List<GroupDTO> list = groupDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }

    /**
    * 查询fetch_user_group_admin 团队
    * 
    *
    * @param dto dto
    * @return ResponseEntity<List<GroupDTO>>
    */
    @ApiOperation(value = "查询fetch_user_group_admin", tags = {"团队" },  notes = "Group-fetch_user_group_admin ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-Group-fetch_user_group_admin-all') or hasPermission(#dto,'ibizplm-Group-fetch_user_group_admin')")
    @PostMapping("groups/fetch_user_group_admin")
    public ResponseEntity<List<GroupDTO>> fetchUserGroupAdmin
            (@Validated @RequestBody GroupFilterDTO dto) {
        GroupSearchContext context = groupFilterDtoMapping.toDomain(dto);
        Page<Group> domains = groupService.searchUserGroupAdmin(context) ;
        List<GroupDTO> list = groupDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


    /**
    * 批量新建团队
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Group-Create-all')")
    @ApiOperation(value = "批量新建团队", tags = {"团队" },  notes = "批量新建团队")
	@PostMapping("groups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<GroupDTO> dtos) {
        groupService.createBatch(groupDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量删除团队
    * @param ids ids
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Group-Remove-all')")
    @ApiOperation(value = "批量删除团队", tags = {"团队" },  notes = "批量删除团队")
	@DeleteMapping("groups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        groupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量更新团队
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Group-Update-all')")
    @ApiOperation(value = "批量更新团队", tags = {"团队" },  notes = "批量更新团队")
	@PutMapping("groups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<GroupDTO> dtos) {
        groupService.updateBatch(groupDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量保存团队
    * @param dtos
    * @return ResponseEntity<Boolean>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Group-Save-all')")
    @ApiOperation(value = "批量保存团队", tags = {"团队" },  notes = "批量保存团队")
	@PostMapping("groups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<GroupDTO> dtos) {
        groupService.saveBatch(groupDtoMapping.toDomain(dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    /**
    * 批量导入团队
    * @param config 导入模式
    * @param ignoreError 导入中忽略错误
    * @return ResponseEntity<ImportResult>
    */
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','plm-Group-Save-all')")
    @ApiOperation(value = "批量导入团队", tags = {"团队" },  notes = "批量导入团队")
	@PostMapping("groups/import")
    public ResponseEntity<ImportResult> importData(@RequestParam(value = "config" , required = false) String config ,@RequestParam(value = "ignoreerror", required = false, defaultValue = "true") Boolean ignoreError ,@RequestBody List<GroupDTO> dtos) {
        return  ResponseEntity.status(HttpStatus.OK).body(groupService.importData(config,ignoreError,groupDtoMapping.toDomain(dtos)));
    }

}
