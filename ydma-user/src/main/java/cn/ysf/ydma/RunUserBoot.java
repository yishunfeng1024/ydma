package cn.ysf.ydma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma
 * @data 2020/4/23
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.ysf.ydma.dao")
@ServletComponentScan
public class RunUserBoot {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(RunUserBoot.class,args);
       // UserService userService = ac.getBean(UserService.class,args);
       // YdmaResult y = userService.addUser("张杰","8848");
        //System.out.println(y);
    }
}

