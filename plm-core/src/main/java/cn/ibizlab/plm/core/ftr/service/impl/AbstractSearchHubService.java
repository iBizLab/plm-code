/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@NoSQL}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ftr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.util.enums.Entities;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ftr.domain.SearchHub;
import cn.ibizlab.plm.core.ftr.filter.SearchHubSearchContext;
import cn.ibizlab.plm.core.ftr.service.SearchHubService;
import cn.ibizlab.plm.core.ftr.repository.SearchHubRepository;
import cn.ibizlab.util.security.AuthenticationUser;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[检索中心] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSearchHubService implements SearchHubService {

    @Autowired
    @Lazy
    SearchHubRepository searchHubRepository;

    protected int batchSize = 500;

    public SearchHub get(SearchHub et) {
        SearchHub rt = searchHubRepository.findById(et.getId()).orElseGet(()->{throw new NotFoundException("数据不存在",Entities.SEARCH_HUB.toString(),et.getId());});
        rt.copyTo(et,true);
        return et;
    }
    
    public List<SearchHub> getByEntities(List<SearchHub> entities) {
        Iterable<SearchHub> rts =  searchHubRepository.findAllById(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
        return Lists.newArrayList(rts);
    }

    public SearchHub getDraft(SearchHub et) {
        return et;
    }

    public Integer checkKey(SearchHub et) {

        return (!ObjectUtils.isEmpty(et.getId()) && searchHubRepository.existsById(et.getId()))?1:0;
    }

    @Override
    @Transactional
    public boolean create(SearchHub et) {
        SearchHub rt = searchHubRepository.insert(et);
        rt.copyTo(et,true);
        get(et);
        return true;
    }

    @Transactional
    public boolean createBatch(List<SearchHub> list) {
        list = searchHubRepository.insert(list);
        return true;
    }

    @Transactional
    public boolean update(SearchHub et) {
        SearchHub rt = searchHubRepository.save(et);
        rt.copyTo(et,true);
        get(et);
        return true;
    }

    @Transactional
    public boolean updateBatch(List<SearchHub> list) {
        list = searchHubRepository.saveAll(list);
        return true;
    }

    @Override
    @Transactional
    public boolean save(SearchHub et) {
        if(checkKey(et) > 0)
            return getSelf().update(et);
        else
            return getSelf().create(et);
    }

    @Transactional
    public boolean saveBatch(List<SearchHub> list) {
        if(ObjectUtils.isEmpty(list))
            return true;
        Map<String,SearchHub> before = getByEntities(list).stream().collect(Collectors.toMap(SearchHub::getId,e->e));
        List<SearchHub> create = new ArrayList<>();
        List<SearchHub> update = new ArrayList<>();
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
    public boolean remove(SearchHub et) {
        String key = et.getId();
        searchHubRepository.deleteById(key);
        return true;
    }

    @Transactional
    public boolean removeByEntities(List<SearchHub> entities) {
        searchHubRepository.deleteAll(entities);
        return true;
    }

    public Page<SearchHub> searchDefault(SearchHubSearchContext context) {
        return searchHubRepository.query(context);
    }
    public List<SearchHub> listDefault(SearchHubSearchContext context) {
        return searchHubRepository.query(context).getContent();
    }


}