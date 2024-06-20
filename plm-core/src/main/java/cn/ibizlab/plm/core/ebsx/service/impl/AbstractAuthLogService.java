/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.ebsx.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.ebsx.client.AuthLogFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.ebsx.domain.AuthLog;
import cn.ibizlab.plm.core.ebsx.filter.AuthLogSearchContext;
import cn.ibizlab.plm.core.ebsx.service.AuthLogService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[认证日志] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractAuthLogService implements AuthLogService {

    @Autowired
    AuthLogFeignClient authLogFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AuthLog et) {
        AuthLog rt = authLogFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<AuthLog> list) {
        return authLogFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(AuthLog et) {
        AuthLog rt = authLogFeignClient.updateByLogId(et.getLogId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<AuthLog> list) {
        return authLogFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(AuthLog et) {
        return authLogFeignClient.removeByLogId(et.getLogId());
    }

    @Transactional
    public boolean remove(List<AuthLog> entities) {
       return authLogFeignClient.removeBatch(entities.stream().map(e->e.getLogId()).collect(Collectors.toList()));
    }		

    public AuthLog get(AuthLog et) {
        return authLogFeignClient.getByLogId(et.getLogId());
    }	

    public List<AuthLog> get(List<AuthLog> entities) {
        return null;
    }	
	
    public AuthLog getDraft(AuthLog et) {
        return authLogFeignClient.getDraft(et);
    }
	
    public Integer checkKey(AuthLog et) {
         return authLogFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(AuthLog et) {
       AuthLog rt =  authLogFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<AuthLog> list) {
        return authLogFeignClient.saveBatch(list);
    }
	
     public Page<AuthLog> fetchDefault(AuthLogSearchContext context) {
        return authLogFeignClient.fetchDefault(context);
    }
	
    public List<AuthLog> listDefault(AuthLogSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	

}