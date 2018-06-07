package com.demo.controller.controllerImpl;

import com.demo.controller.HelloController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerImpl implements HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET,name = "helloService")
    public  @ResponseBody String hello(){


      //  ThreadLocal<String > threadLocal=new ThreadLocal<String>();


        System.out.println("访问成功");

        return "hello";

       /* CharSequence sequence=new CharSequence() {
            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int index) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        }*/

    }

}
