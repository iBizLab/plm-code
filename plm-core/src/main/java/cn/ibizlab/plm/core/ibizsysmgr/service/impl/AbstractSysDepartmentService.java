/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ibizsysmgr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ibizsysmgr.client.SysDepartmentFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ibizsysmgr.domain.SysDepartment;
import cn.ibizlab.plm.core.ibizsysmgr.filter.SysDepartmentSearchContext;
import cn.ibizlab.plm.core.ibizsysmgr.service.SysDepartmentService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[部门] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSysDepartmentService implements SysDepartmentService {

    @Autowired
    SysDepartmentFeignClient sysDepartmentFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysDepartment et) {
        SysDepartment rt = sysDepartmentFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SysDepartment> list) {
        return sysDepartmentFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SysDepartment et) {
        SysDepartment rt = sysDepartmentFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SysDepartment> list) {
        return sysDepartmentFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SysDepartment et) {
        return sysDepartmentFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SysDepartment> entities) {
       return sysDepartmentFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SysDepartment get(SysDepartment et) {
        return sysDepartmentFeignClient.getById(et.getId());
    }	

    public List<SysDepartment> get(List<SysDepartment> entities) {
        return null;
    }	
	
    public SysDepartment getDraft(SysDepartment et) {
        return sysDepartmentFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SysDepartment et) {
         return sysDepartmentFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SysDepartment et) {
       SysDepartment rt =  sysDepartmentFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SysDepartment> list) {
        return sysDepartmentFeignClient.saveBatch(list);
    }
	
     public Page<SysDepartment> fetchDefault(SysDepartmentSearchContext context) {
        return sysDepartmentFeignClient.fetchDefault(context);
    }
	
    public List<SysDepartment> listDefault(SysDepartmentSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	

}