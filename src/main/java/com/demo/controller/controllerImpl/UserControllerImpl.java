package com.demo.controller.controllerImpl;

import com.demo.controller.UserController;
import com.demo.entity.Role;
import com.demo.entity.SimpleUser;
import com.demo.entity.User;
import com.demo.entity.UserRole;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("uc")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    private static Logger logger=LoggerFactory.getLogger(UserControllerImpl.class);


    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping(value = "userLogin",method = RequestMethod.GET)
    @Override
    @ResponseBody
    public Map<String ,Object> userLogin(@Valid SimpleUser user) {

        logger.info("info:username:"+user.getUsername());
        logger.debug("debug:username:"+user.getPassword());

        return userService.userLogin(user.getUsername(),user.getPassword());

    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @Override
    public User getUser(String username, String password) {

        return userService.getUser(username,password);
    }

    @RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "/login";
    }

    /**
     * 验证valid
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping("/testValid")
    private String testValid(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<ObjectError>  errorList = bindingResult.getAllErrors();
            for (ObjectError error:errorList){
                System.out.println(error.getDefaultMessage());
            }
        }else {
            System.out.println("没有错误");
        }
        return "test";
    }

    @RequestMapping("getUserRoleMess")
    @Override
    public UserRole getUserRoleMess() {
        return userService.getUserRoleMess();
    }

    /**
     * 一对多关联查询
     * @param role_id
     * @return
     */
    @RequestMapping("getRolePermission")
    @Override
    public List<Role> getRolePermission(
            @RequestParam(value = "role_id",required = false,defaultValue = "1") int role_id) {
        return userService.getRolePermission(role_id);
    }
}
