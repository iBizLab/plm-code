/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/service/impl/Abstract{{entities@ServiceAPI}}Service.java.hbs
 */
package cn.ibizlab.plm.core.extension.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.plm.core.extension.client.SystemExtensionNotifySettingFeignClient;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.util.*;
import cn.ibizlab.util.errors.*;
import cn.ibizlab.util.enums.CheckKeyStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting;
import cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext;
import cn.ibizlab.plm.core.extension.service.SystemExtensionNotifySettingService;
import com.alibaba.fastjson.JSONObject;

/**
 * 实体[通知设置] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
public abstract class AbstractSystemExtensionNotifySettingService implements SystemExtensionNotifySettingService {

    @Autowired
    SystemExtensionNotifySettingFeignClient systemExtensionNotifySettingFeignClient;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SystemExtensionNotifySetting et) {
        SystemExtensionNotifySetting rt = systemExtensionNotifySettingFeignClient.create(et);
        rt.copyTo(et,true);
        return true;
    }
	
    @Transactional
    public boolean create(List<SystemExtensionNotifySetting> list) {
        return systemExtensionNotifySettingFeignClient.createBatch(list);
    }
	
    @Transactional
    public boolean update(SystemExtensionNotifySetting et) {
        SystemExtensionNotifySetting rt = systemExtensionNotifySettingFeignClient.updateById(et.getId(), et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean update(List<SystemExtensionNotifySetting> list) {
        return systemExtensionNotifySettingFeignClient.updateBatch(list);
    }
	
   @Transactional
    public boolean remove(SystemExtensionNotifySetting et) {
        return systemExtensionNotifySettingFeignClient.removeById(et.getId());
    }

    @Transactional
    public boolean remove(List<SystemExtensionNotifySetting> entities) {
       return systemExtensionNotifySettingFeignClient.removeBatch(entities.stream().map(e->e.getId()).collect(Collectors.toList()));
    }		

    public SystemExtensionNotifySetting get(SystemExtensionNotifySetting et) {
        return systemExtensionNotifySettingFeignClient.getById(et.getId());
    }	

    public List<SystemExtensionNotifySetting> get(List<SystemExtensionNotifySetting> entities) {
        return null;
    }	
	
    public SystemExtensionNotifySetting getDraft(SystemExtensionNotifySetting et) {
        return systemExtensionNotifySettingFeignClient.getDraft(et);
    }
	
    public CheckKeyStatus checkKey(SystemExtensionNotifySetting et) {
         return systemExtensionNotifySettingFeignClient.checkKey(et);
    }
	
    @Override
    @Transactional
    public boolean save(SystemExtensionNotifySetting et) {
       SystemExtensionNotifySetting rt =  systemExtensionNotifySettingFeignClient.save(et);
        rt.copyTo(et,true);
        return true;
    }

    @Transactional
    public boolean save(List<SystemExtensionNotifySetting> list) {
        return systemExtensionNotifySettingFeignClient.saveBatch(list);
    }
	
     public Page<SystemExtensionNotifySetting> fetchDefault(SystemExtensionNotifySettingSearchContext context) {
        return systemExtensionNotifySettingFeignClient.fetchDefault(context);
    }
	
    public List<SystemExtensionNotifySetting> listDefault(SystemExtensionNotifySettingSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchDefault(context).getContent();
    }
	
     public Page<SystemExtensionNotifySetting> fetchView(SystemExtensionNotifySettingSearchContext context) {
        return systemExtensionNotifySettingFeignClient.fetchView(context);
    }
	
    public List<SystemExtensionNotifySetting> listView(SystemExtensionNotifySettingSearchContext context) {
        context.setSize(Short.MAX_VALUE);
        return fetchView(context).getContent();
    }
	

}