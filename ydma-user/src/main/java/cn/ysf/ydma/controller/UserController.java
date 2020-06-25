package cn.ysf.ydma.controller;

import cn.ysf.ydma.service.UserService;
import cn.ysf.ydma.ysf.util.YdmaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.controller
 * @data 2020/4/23
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public YdmaResult register(String name, String password){
        YdmaResult ydmaResult = userService.addUser(name, password);
        return ydmaResult;
    }
    @PostMapping("/user/login")
    public YdmaResult login(String name,String password){
        YdmaResult ydmaResult = userService.checkUser(name,password);
        return ydmaResult;
    }
    @PostMapping("/user/find")
    public YdmaResult find(int id){
        YdmaResult ydmaResult = userService.findOne(id);
        return  ydmaResult;
    }

}
