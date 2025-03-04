/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@SQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.team.service.impl;

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
import cn.ibizlab.plm.core.team.domain.DiscussTopic;
import cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext;
import cn.ibizlab.plm.core.team.service.DiscussTopicService;
import cn.ibizlab.plm.core.team.mapper.DiscussTopicMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.team.domain.DiscussMember;
import cn.ibizlab.plm.core.team.service.DiscussMemberService;
import cn.ibizlab.plm.core.team.domain.DiscussPost;
import cn.ibizlab.plm.core.team.service.DiscussPostService;

/**
 * 实体[话题] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractDiscussTopicService extends ServiceImpl<DiscussTopicMapper,DiscussTopic> implements DiscussTopicService {

    @Autowired
    @Lazy
    protected DiscussMemberService discussMemberService;

    @Autowired
    @Lazy
    protected DiscussPostService discussPostService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DiscussTopic et) {
        if(this.baseMapper.insert(et) < 1)
            return false;
        discussMemberService.saveByDiscussTopic(et,et.getMembers());
        get(et);
        return true;
    }
	
    @Transactional
    public boolean create(List<DiscussTopic> list) {
        this.saveBatch(list, batchSize);
        return true;
    }
	
    @Transactional
    public boolean update(DiscussTopic et) {
        UpdateWrapper<DiscussTopic> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        discussMemberService.saveByDiscussTopic(et,et.getMembers());
        get(et);
        return true;
    }

    @Transactional
    public boolean update(List<DiscussTopic> list) {
        updateBatchById(list, batchSize);
        return true;
    }
	
   @Transactional
    public boolean remove(DiscussTopic et) {
        if(!remove(Wrappers.<DiscussTopic>lambdaQuery().eq(DiscussTopic::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean remove(List<DiscussTopic> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }		
    public DiscussTopic get(DiscussTopic et) {
        DiscussTopic rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.DISCUSS_TOPIC.toString(),et.getId());
        rt.copyTo(et,true);
        //设置 [协作成员]
        getMembers(et);
        return et;
    }	

    public List<DiscussTopic> get(List<DiscussTopic> entities) {
        return this.baseMapper.selectEntities(entities);
    }	
	
    public DiscussTopic getDraft(DiscussTopic et) {
        return et;
    }
	
    public CheckKeyStatus checkKey(DiscussTopic et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<DiscussTopic>lambdaQuery().eq(DiscussTopic::getId, et.getId()))>0)? CheckKeyStatus.FOUNDED : CheckKeyStatus.NOT_FOUND;
    }
	
    @Override
    @Transactional
    public boolean save(DiscussTopic et) {
        if(CheckKeyStatus.FOUNDED == checkKey(et))
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean save(List<DiscussTopic> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,DiscussTopic> before = get(list).stream().collect(Collectors.toMap(DiscussTopic::getId,e->e));
        List<DiscussTopic> create = new ArrayList<>();
        List<DiscussTopic> update = new ArrayList<>();
        list.forEach(sub->{
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
	
   public Page<DiscussTopic> fetchDefault(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listDefault(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussTopic> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchAdmin(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchAdmin(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listAdmin(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listAdmin(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchArchived(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchArchived(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listArchived(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listArchived(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchArchivedMain(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchArchivedMain(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listArchivedMain(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listArchivedMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchDeleted(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchDeleted(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listDeleted(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("UPDATE_TIME,DESC");
        List<DiscussTopic> list = baseMapper.listDeleted(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchFavorite(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchFavorite(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listFavorite(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussTopic> list = baseMapper.listFavorite(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchGroup(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchGroup(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listGroup(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussTopic> list = baseMapper.listGroup(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchMain(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchMain(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listMain(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchNormal(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchNormal(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listNormal(DiscussTopicSearchContext context) {
        if(context.getPageSort() == null || context.getPageSort() == Sort.unsorted())
            context.setSort("CREATE_TIME,DESC");
        List<DiscussTopic> list = baseMapper.listNormal(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchOssMain(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchOssMain(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listOssMain(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listOssMain(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchQuickUser(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchQuickUser(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listQuickUser(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listQuickUser(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchReader(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchReader(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listReader(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listReader(context,context.getSelectCond());
        return list;
   }
	
   public Page<DiscussTopic> fetchUser(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchUser(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listUser(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listUser(context,context.getSelectCond());
        return list;
   }
	
	@Override
    public List<DiscussMember> getMembers(DiscussTopic et) {
        List<DiscussMember> list = discussMemberService.findByDiscussTopic(et);
        et.setMembers(list);
        return list;
    }
	
   public Page<DiscussTopic> fetchView(DiscussTopicSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DiscussTopic> pages=baseMapper.searchView(context.getPages(),context,context.getSelectCond());
        List<DiscussTopic> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

   public List<DiscussTopic> listView(DiscussTopicSearchContext context) {
        List<DiscussTopic> list = baseMapper.listView(context,context.getSelectCond());
        return list;
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
        return DiscussTopicMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return DiscussTopic.class;
    }

}