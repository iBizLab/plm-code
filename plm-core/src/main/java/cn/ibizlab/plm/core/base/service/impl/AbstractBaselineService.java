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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.base.domain.Baseline;
import cn.ibizlab.plm.core.base.filter.BaselineSearchContext;
import cn.ibizlab.plm.core.base.service.BaselineService;
import cn.ibizlab.plm.core.base.mapper.BaselineMapper;
import cn.ibizlab.plm.util.enums.Entities;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.service.LibraryService;
import cn.ibizlab.plm.core.prodmgmt.domain.Product;
import cn.ibizlab.plm.core.prodmgmt.service.ProductService;
import cn.ibizlab.plm.core.projmgmt.domain.Project;
import cn.ibizlab.plm.core.projmgmt.service.ProjectService;
import cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea;
import cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService;
import cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase;
import cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService;
import cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem;
import cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService;
import cn.ibizlab.plm.core.base.domain.Relation;
import cn.ibizlab.plm.core.base.service.RelationService;

/**
 * 实体[基线] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractBaselineService extends ServiceImpl<BaselineMapper,Baseline> implements BaselineService {

    @Autowired
    @Lazy
    protected LibraryService libraryService;

    @Autowired
    @Lazy
    protected ProductService productService;

    @Autowired
    @Lazy
    protected ProjectService projectService;

    @Autowired
    @Lazy
    protected BaselineIdeaService baselineIdeaService;

    @Autowired
    @Lazy
    protected BaselineTestCaseService baselineTestCaseService;

    @Autowired
    @Lazy
    protected BaselineWorkItemService baselineWorkItemService;

    @Autowired
    @Lazy
    protected RelationService relationService;

    protected int batchSize = 500;

    public Baseline get(Baseline et) {
        Baseline rt = this.baseMapper.selectEntity(et);
        if(rt == null)
            throw new NotFoundException("数据不存在",Entities.BASELINE.toString(),et.getId());
        rt.copyTo(et,true);
        return et;
    }

    public List<Baseline> getByEntities(List<Baseline> entities) {
        return this.baseMapper.selectEntities(entities);
    }

    public void fillParentData(Baseline et) {
        if(Entities.LIBRARY.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PRODUCT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
        if(Entities.PROJECT.equals(et.getContextParentEntity()) && et.getContextParentKey()!=null) {
            et.setOwnerId((String)et.getContextParentKey());
        }
    }

    public Baseline getDraft(Baseline et) {
        fillParentData(et);
        return et;
    }

    public Integer checkKey(Baseline et) {
        return (!ObjectUtils.isEmpty(et.getId()) && this.count(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId()))>0)?1:0;
    }

    @Override
    @Transactional
    public boolean create(Baseline et) {
        fillParentData(et);
        if(this.baseMapper.insert(et) < 1)
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<Baseline> list) {
        list.forEach(this::fillParentData);
        this.saveBatch(list, batchSize);
        return true;
    }

    @Transactional
    public boolean update(Baseline et) {
        UpdateWrapper<Baseline> qw = et.getUpdateWrapper(true);
        qw.eq("id", et.getId());
        if(!update(et, qw))
            return false;
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<Baseline> list) {
        updateBatchById(list, batchSize);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Baseline et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<Baseline> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,Baseline> before = getByEntities(list).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> create = new ArrayList<>();
        List<Baseline> update = new ArrayList<>();
        list.forEach(sub->{
            if(!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId()))
                update.add(sub);
            else
                create.add(sub);
        });
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else
            return true;
    }

    @Transactional
    public boolean remove(Baseline et) {
        if(!remove(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getId, et.getId())))
            return false;
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<Baseline> entities) {
        this.baseMapper.deleteEntities(entities);
        return true;
    }

    public Page<Baseline> searchDefault(BaselineSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Baseline> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        List<Baseline> list = pages.getRecords();
        return new PageImpl<>(list, context.getPageable(), pages.getTotal());
    }

    public List<Baseline> listDefault(BaselineSearchContext context) {
        List<Baseline> list = baseMapper.listDefault(context,context.getSelectCond());
        return list;
    }

    public List<Baseline> findByOwnerId(List<String> ownerIds) {
        List<Baseline> list = baseMapper.findByOwnerId(ownerIds);
        return list;
    }
    public boolean removeByOwnerId(String ownerId) {
        return this.remove(Wrappers.<Baseline>lambdaQuery().eq(Baseline::getOwnerId,ownerId));
    }

    public boolean resetByOwnerId(String ownerId) {
        return this.update(Wrappers.<Baseline>lambdaUpdate().eq(Baseline::getOwnerId,ownerId));
    }

    public boolean saveByLibrary(Library library,List<Baseline> list) {
        if(list==null)
            return true;
        Map<String,Baseline> before = findByOwnerId(library.getId()).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(library.getId());
            sub.setLibrary(library);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByProduct(Product product,List<Baseline> list) {
        if(list==null)
            return true;
        Map<String,Baseline> before = findByOwnerId(product.getId()).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(product.getId());
            sub.setProduct(product);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    public boolean saveByProject(Project project,List<Baseline> list) {
        if(list==null)
            return true;
        Map<String,Baseline> before = findByOwnerId(project.getId()).stream().collect(Collectors.toMap(Baseline::getId,e->e));
        List<Baseline> update = new ArrayList<>();
        List<Baseline> create = new ArrayList<>();

        for(Baseline sub:list) {
            sub.setOwnerId(project.getId());
            sub.setProject(project);
            if(!ObjectUtils.isEmpty(sub.getId())&&before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            }
            else
                create.add(sub);
        }
        if(!update.isEmpty())
            update.forEach(item->this.getSelf().update(item));
        if(!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if(!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
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
        return BaselineMapper.class;
    }

    @Override
    protected Class currentModelClass() {
        return Baseline.class;
    }
}