/**
 * Generate code from /{{projectName}}-user/src/main/java/{{packageName}}/util/security/AuthPermissionEvaluator.java.hbs
 */
// @// @SkipOverwrite
package cn.ibizlab.plm.util.security;

import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.plm.util.enums.Entities;
import cn.ibizlab.util.filter.ISearchContext;
import cn.ibizlab.util.helper.BeanCache;
import cn.ibizlab.util.service.AbstractPermissionEvaluator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * spring security 权限管理类
 * 重写权限控制方法
 *
 * @author generator
 */
@Component
public class AuthPermissionEvaluator extends AbstractPermissionEvaluator {

    @Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验

    @Override
    public boolean isEnablePermissionValid() {
        return enablePermissionValid;
    }

    @Override
    public BeanCache.BeanSchema getSchema(String entityTag) {
        Entities entity = Entities.from(entityTag).orElse(null);
        return entity == null ? null : entity.getSchema();
    }


    /**
     * 实体查询数据权限条件附加
     * @param qc 接口过滤入参  附加条件在此参数中
     * @param entityTag 实体标记
     * @param action 查询方法名
     * @param permission 接口权限资源符
     * @param userAuthorities 相关权限资源
     * @param authenticationUser 当前操作者
     */
    @Override
    public void addFetchPermissionCondition(ISearchContext qc, String entityTag, String action, String permission, Set<String> userAuthorities, AuthenticationUser authenticationUser){
        super.addFetchPermissionCondition(qc, entityTag, action, permission, userAuthorities, authenticationUser);
    }

    /**
     * 实体行为权限校验
     * @param entity 接口入参
     * @param entityTag 实体标记
     * @param action 行为方法名
     * @param permission 接口权限资源符
     * @param userAuthorities 相关权限资源
     * @param authenticationUser 当前操作者
     * @return boolean
     */
    @Override
    public boolean actionValid(IEntity entity, String entityTag, String action, String permission, Set<String> userAuthorities, AuthenticationUser authenticationUser){
        return super.actionValid(entity, entityTag, action, permission, userAuthorities, authenticationUser);
    }

}