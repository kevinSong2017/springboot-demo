package com.demo.controller.controllerImpl;

import com.demo.controller.UserController;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("uc")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    private static Logger logger=LoggerFactory.getLogger(UserControllerImpl.class);

    /**
     * @return
     */
    @RequestMapping("/hello")
    public String helloHtml( ) {
        System.out.println("进入跳转方法");
        return "login";
    }


    @RequestMapping(value = "userLogin",method = RequestMethod.GET)
    @Override
    public Map<String ,Object> userLogin(String username, String password) {

        logger.info("info:username:"+username);
        logger.debug("debug:username:"+username);

        return userService.userLogin(username,password);

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





}
