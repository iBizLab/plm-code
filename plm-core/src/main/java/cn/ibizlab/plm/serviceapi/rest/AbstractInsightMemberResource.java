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
import cn.ibizlab.plm.core.insight.domain.InsightMember;
import cn.ibizlab.plm.core.insight.service.InsightMemberService;
import cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

/**
 * 实体[InsightMember] rest实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractInsightMemberResource {

    @Autowired
    public InsightMemberService insightMemberService;

    @Autowired
    @Lazy
    public InsightMemberDTOMapping insightMemberDtoMapping;

    @Autowired
    @Lazy
    public InsightMemberFilterDTOMapping insightMemberFilterDtoMapping;

    /**
    * 创建Create 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */
    @ApiOperation(value = "创建Create", tags = {"效能成员" },  notes = "InsightMember-Create ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Create-all') or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Create')")
    @PostMapping("insight_views/{ownerId}/insight_members")
    public ResponseEntity<ResponseWrapper<InsightMemberDTO>> createByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(createByOwnerId(ownerId, item)));
        else
            rt.set(createByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 创建Create 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO createByOwnerId
            (String ownerId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        insightMemberService.create(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */
    @ApiOperation(value = "更新Update", tags = {"效能成员" },  notes = "InsightMember-Update ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Update-all') or hasPermission('insight_view',#ownerId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Update')")
    @VersionCheck(entity = "insightmember" , versionfield = "updateTime")
    @PutMapping("insight_views/{ownerId}/insight_members/{id}")
    public ResponseEntity<ResponseWrapper<InsightMemberDTO>> updateByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray()) {
            String [] ids = id.split(";");
            IntStream.range(0, ids.length).forEach(i -> rt.add(updateByOwnerIdAndId(ownerId, ids[i], dto.getList().get(i))));
        }
        else
            rt.set(updateByOwnerIdAndId(ownerId, id, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 更新Update 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO updateByOwnerIdAndId
            (String ownerId, String id, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setId(id);
        insightMemberService.update(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */
    @ApiOperation(value = "保存Save", tags = {"效能成员" },  notes = "InsightMember-Save ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Save-all') or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(#dto),'ibizplm-InsightMember-Save')")
    @PostMapping("insight_views/{ownerId}/insight_members/save")
    public ResponseEntity<ResponseWrapper<InsightMemberDTO>> saveByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody RequestWrapper<InsightMemberDTO> dto) {
        ResponseWrapper<InsightMemberDTO> rt = new ResponseWrapper<>();
        if (dto.isArray())
            dto.getList().forEach(item -> rt.add(saveByOwnerId(ownerId, item)));
        else
            rt.set(saveByOwnerId(ownerId, dto.getDto()));
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 保存Save 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */   
    public InsightMemberDTO saveByOwnerId
            (String ownerId, InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        insightMemberService.save(domain);
        InsightMember rt = domain;
        return insightMemberDtoMapping.toDto(rt);
    }


    /**
    * 获取Get 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<InsightMemberDTO>
    */
    @ApiOperation(value = "获取Get", tags = {"效能成员" },  notes = "InsightMember-Get ")
    @PostAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Get-all')  or hasPermission('insight_view',#ownerId,this.insightMemberDtoMapping.toDomain(returnObject.body),'ibizplm-InsightMember-Get')")
    @GetMapping("insight_views/{ownerId}/insight_members/{id}")
    public ResponseEntity<InsightMemberDTO> getByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        InsightMember rt = insightMemberService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt));
    }

    /**
    * 删除Remove 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param id id
    * @return ResponseEntity<Boolean>
    */
    @ApiOperation(value = "删除Remove", tags = {"效能成员" },  notes = "InsightMember-Remove ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-Remove-all') or hasPermission('insight_view',#ownerId,this.insightMemberService.get(#id),'ibizplm-InsightMember-Remove')")
    @DeleteMapping("insight_views/{ownerId}/insight_members/{id}")
    public ResponseEntity<Boolean> removeByOwnerIdAndId
            (@PathVariable("ownerId") String ownerId, @PathVariable("id") String id) {
        Boolean rt = insightMemberService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 校验CheckKey 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<Integer>
    */
    @ApiOperation(value = "校验CheckKey", tags = {"效能成员" },  notes = "InsightMember-CheckKey ")
    @PostMapping("insight_views/{ownerId}/insight_members/check_key")
    public ResponseEntity<Integer> checkKeyByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        Integer rt = insightMemberService.checkKey(domain);
        return ResponseEntity.status(HttpStatus.OK).body(rt);
    }

    /**
    * 草稿GetDraft 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<InsightMemberDTO>
    */
    @ApiOperation(value = "草稿GetDraft", tags = {"效能成员" },  notes = "InsightMember-GetDraft ")
    @GetMapping("insight_views/{ownerId}/insight_members/get_draft")
    public ResponseEntity<InsightMemberDTO> getDraftByOwnerId
            (@PathVariable("ownerId") String ownerId, @SpringQueryMap InsightMemberDTO dto) {
        InsightMember domain = insightMemberDtoMapping.toDomain(dto);
        domain.setOwnerId(ownerId);
        InsightMember rt = insightMemberService.getDraft(domain);
        return ResponseEntity.status(HttpStatus.OK).body(insightMemberDtoMapping.toDto(rt));
    }

    /**
    * 查询fetch_default 效能成员
    * 
    *
    * @param ownerId ownerId
    * @param dto dto
    * @return ResponseEntity<List<InsightMemberDTO>>
    */
    @ApiOperation(value = "查询fetch_default", tags = {"效能成员" },  notes = "InsightMember-fetch_default ")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibizplm-InsightMember-fetch_default-all') or hasPermission('insight_view',#ownerId,#dto,'ibizplm-InsightMember-fetch_default')")
    @PostMapping("insight_views/{ownerId}/insight_members/fetch_default")
    public ResponseEntity<List<InsightMemberDTO>> fetchDefaultByOwnerId
            (@PathVariable("ownerId") String ownerId, @Validated @RequestBody InsightMemberFilterDTO dto) {
        dto.setOwnerIdEQ(ownerId);
        InsightMemberSearchContext context = insightMemberFilterDtoMapping.toDomain(dto);
        Page<InsightMember> domains = insightMemberService.fetchDefault(context) ;
        List<InsightMemberDTO> list = insightMemberDtoMapping.toDto(domains.getContent());
            return ResponseEntity.status(HttpStatus.OK)
            .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
            .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
            .header("x-total", String.valueOf(domains.getTotalElements()))
            .body(list);
    }


}
