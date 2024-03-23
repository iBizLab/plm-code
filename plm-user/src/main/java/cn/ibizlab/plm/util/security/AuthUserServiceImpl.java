/**
 * Generate code from /{{projectName}}-user/src/main/java/{{packageName}}/util/security/AuthUserServiceImpl.java.hbs
 */
// @SkipOverwrite
package cn.ibizlab.plm.util.security;

import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AbstractAuthUserService;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * spring security 认证管理类
 * 重写认证填充方法
 *
 * @author generator
 */
@Service
public class AuthUserServiceImpl extends AbstractAuthUserService {

    @Override
    protected AuthenticationUser createAuthenticationUser(AuthenticationUser adapterUser) {
        return super.createAuthenticationUser(adapterUser);
    }

    @Override
    public Map getAppData() {
        return super.getAppData();
    }

}