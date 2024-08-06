/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.base.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Member;
import cn.ibizlab.plm.core.base.filter.MemberSearchContext;
import cn.ibizlab.plm.core.base.service.MemberService;
import cn.ibizlab.plm.core.base.mapper.MemberMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.base.domain.User;
import cn.ibizlab.plm.core.base.domain.CommonFlow;
import cn.ibizlab.plm.core.base.domain.Group;
import cn.ibizlab.plm.core.base.service.GroupService;
import cn.ibizlab.plm.core.wiki.domain.ArticlePage;
import cn.ibizlab.plm.core.wiki.service.ArticlePageService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;

/**
 * 实体[成员] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractMemberService extends ServiceImpl<MemberMapper,Member> implements MemberService {

    @Autowired
    @Lazy
    protected GroupService groupService;

    @Autowired
    @Lazy
    protected ArticlePageService articlePageService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(Member et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<Member> list) {
        list.forEach(this::fillParentData);
        list.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(Member et) {
        fillParentData(et);
        UpdateWrapper<Member> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<Member> list) {
        list.forEach(this::fillParentData);
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(Member et) {
        if(!remove(Wrappers.<Member>lambdaQuery().eq(Member::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<Member> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public Member get(Member et) {
        Member rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.MEMBER.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }	

    public List<Member> get(List<Member> entities) {
        entities.forEach(et->{
            if(ObjectUtils.isEmpty(et.getId()))
                et.setId((String)et.getDefaultKey(true));
            });
        return this.baseMapper.selectEntities(entities);
    }	
	
    public Member getDraft(Member et) {
        fillParentData(et);
        return et;
    }
	
    public CheckKeyStatus checkKey(Member et) {
        fillParentData(et);
        if(ObjectUtils.isEmpty(et.getId()))
            et.setId((String)et.getDefaultKey(true));
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Member>lambdaQuery().eq(Member::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(Member et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<Member> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Member> before = get(list).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> create = new ArrayList<>();
        List<Member> update = new ArrayList<>();
        list.forEach(sub->{
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else
            return true;
    }
	
   public Page<Member> fetchDefault(MemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Member> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Member> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Member> listDefault(MemberSearchContext context) {
        List<Member> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<Member> fetchSharedPageMember(MemberSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Member> pages=baseMapper.searchSharedPageMember(context.getPages(),context,context.getSelectCond());
        List<Member> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Member> listSharedPageMember(MemberSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<Member> list = baseMapper.listSharedPageMember(context,context.getSelectCond());
        return list;
   }
	
   public Page<Member> fetchUserGroupAdmin(MemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Member> pages=baseMapper.searchUserGroupAdmin(context.getPages(),context,context.getSelectCond());
        List<Member> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Member> listUserGroupAdmin(MemberSearchContext context) {
        List<Member> list = baseMapper.listUserGroupAdmin(context,context.getSelectCond());
        return list;
   }
	
	public List<Member> findByUserId(List<String> userIds){
        List<Member> list = baseMapper.findByUserId(userIds);
        return list;	
	}

	public List<Member> findByUser(User user){
        List<Member> list = findByUserId(Arrays.asList(user.getId()));
		return list;
	}
	public boolean removeByUserId(String userId){
        return this.remove(Wrappers.<Member>lambdaQuery().eq(Member::getUserId,userId));
	}

	public boolean resetByUserId(String userId){
		return this.update(Wrappers.<Member>lambdaUpdate().eq(Member::getUserId,userId));
	}
	public boolean saveByUser(User user, List<Member> list){
        if(list==null)
            return true;

        Map<String,Member> before = findByUser(user).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setUserId(user.getId());
            sub.setUser(user);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Member> findById(List<String> ids){
        List<Member> list = baseMapper.findById(ids);
        return list;	
	}

	public List<Member> findByMemberCommonFlow(CommonFlow commonFlow){
        List<Member> list = this.baseMapper.selectList(Wrappers.<Member>lambdaQuery()
                        .eq(Member::getId, commonFlow.getId())
                        .eq(Member::getOwnerType,"COMMON_FLOW").isNull(Member::getOwnerSubtype));
		return list;
	}
	public boolean removeById(String id){
        return this.remove(Wrappers.<Member>lambdaQuery().eq(Member::getId,id));
	}

	public boolean resetById(String id){
		return this.update(Wrappers.<Member>lambdaUpdate().eq(Member::getId,id));
	}
	public boolean saveByMemberCommonFlow(CommonFlow commonFlow, List<Member> list){
        if(list==null)
            return true;

        Map<String,Member> before = findByMemberCommonFlow(commonFlow).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setId(commonFlow.getId());
            sub.setMemberCommonFlow(commonFlow);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Member> findByOwnerId(List<String> ownerIds){
        List<Member> list = baseMapper.findByOwnerId(ownerIds);
        return list;	
	}

	public List<Member> findByMemberGroup(Group group){
        List<Member> list = this.baseMapper.selectList(Wrappers.<Member>lambdaQuery()
                        .eq(Member::getOwnerId, group.getId())
                        .eq(Member::getOwnerType,"GROUP")
                        .eq(Member::getOwnerSubtype,"GROUP"));
		return list;
	}
	public boolean removeByOwnerId(String ownerId){
        return this.remove(Wrappers.<Member>lambdaQuery().eq(Member::getOwnerId,ownerId));
	}

	public boolean resetByOwnerId(String ownerId){
		return this.update(Wrappers.<Member>lambdaUpdate().eq(Member::getOwnerId,ownerId));
	}
	public boolean saveByMemberGroup(Group group, List<Member> list){
        if(list==null)
            return true;

        Map<String,Member> before = findByMemberGroup(group).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setOwnerId(group.getId());
            sub.setMemberGroup(group);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Member> findBySharedPageMember(ArticlePage articlePage){
        List<Member> list = this.baseMapper.selectList(Wrappers.<Member>lambdaQuery()
                        .eq(Member::getOwnerId, articlePage.getId())
                        .eq(Member::getOwnerType,"PAGE")
                        .eq(Member::getOwnerSubtype,"SHARED"));
		return list;
	}
	public boolean saveBySharedPageMember(ArticlePage articlePage, List<Member> list){
        if(list==null)
            return true;

        Map<String,Member> before = findBySharedPageMember(articlePage).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setOwnerId(articlePage.getId());
            sub.setSharedPageMember(articlePage);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
	public List<Member> findByProjectResource(Project project){
        List<Member> list = this.baseMapper.selectList(Wrappers.<Member>lambdaQuery()
                        .eq(Member::getOwnerId, project.getId())
                        .eq(Member::getOwnerType,"PROJECT")
                        .eq(Member::getOwnerSubtype,"PROJECT_RESOURCE"));
		return list;
	}
	public boolean saveByProjectResource(Project project, List<Member> list){
        if(list==null)
            return true;

        Map<String,Member> before = findByProjectResource(project).stream().collect(Collectors.toMap(Member::getId,e->e));
        List<Member> update = new ArrayList<>();
        List<Member> create = new ArrayList<>();

        for(Member sub:list) {
            sub.setOwnerId(project.getId());
            sub.setProjectResource(project);
            if(ObjectUtils.isEmpty(sub.getId()))
                before.values().stream()
                        .filter(e->ObjectUtils.nullSafeEquals(sub.getDefaultKey(true),e.getDefaultKey(true)))
                        .findFirst().ifPresent(e->sub.setId(e.getId()));
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().create(create))
            return false;
        else if(!before.isEmpty() && !getSelf().remove(before.keySet()))
            return false;
        else
            return true;
			
	}
   public Page<Member> fetchView(MemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Member> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<Member> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<Member> listView(MemberSearchContext context) {
        List<Member> list = baseMapper.listView(context,context.getSelectCond());
        return list;
   }
	

    public void fillParentData(Member et) {
        if(Entities.GROUP.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.ARTICLE_PAGE.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
    }


    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.INSERT_ONE.getMethod())) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.UPDATE.getMethod())) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith(SqlMethod.DELETE.getMethod())) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }
	
	@Override
    protected Class currentMapperClass() {
        return MemberMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Member.class;
    }

}