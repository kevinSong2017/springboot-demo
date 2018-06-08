/*

package com.demo.shiro;


import com.demo.dao.PermissionDao;
import com.demo.entity.Permission;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

*/
/**
 * 添加Realm 验证
 *
 *//*

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger=LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionDao permissionDao;

    */
/**
     * Authorization：授权信息
     * @param principals
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo: +"+principalCollection.toString());
        User user=userService.getByUserName((String) principalCollection.getPrimaryPrincipal());

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //赋予角色
        for(Role userRole:user.getRoles()){
            info.addRole(userRole.getName());
        }
        //赋予权限
        for (Permission permission :permissionDao.getByUserId(user.getId())){
            info.addStringPermission(permission.getName());
        }
        //设置登陆次数，时间
        //userService.updateUserLogin(user);
        return info;
    }

    */
/**
     * Authentication：证明 身份
     * @param token
     * @return
     * @throws AuthenticationException
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("1.doGetAuthenticationInfo: +"+authenticationToken.toString());
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info("2."+userName+token.getPassword());

        User user=userService.getByUserName(token.getUsername());

        if(user!=null){
            //设置用户session
            Session session=SecurityUtils.getSubject().getSession();
            session.setAttribute("user",user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        }else {
            return  null;
        }
    }
}
*/
