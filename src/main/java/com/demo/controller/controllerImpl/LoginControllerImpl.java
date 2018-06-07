package com.demo.controller.controllerImpl;
import com.demo.controller.LoginController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆控制器
 */
@RestController
@RequestMapping("lg")
public class LoginControllerImpl implements LoginController {

    private Logger logger =LoggerFactory.getLogger(LoginControllerImpl.class);

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe
    ){
        logger.info("==========" + userName + password + rememberMe);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        token.setRememberMe(rememberMe);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "您的账号或密码输入错误";
        }
        return "登陆成功";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "no permission";
    }


}
