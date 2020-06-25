package cn.ysf.ydma.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.web
 * @data 2020/5/17
 */
@Controller
public class WebController {
    @RequestMapping("/study/index")
    ///@ResponseBody
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/study/regist")
    public ModelAndView regist(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("regist");
        return mav;
    }
    @RequestMapping("/study/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    @RequestMapping("/study/course")
    public ModelAndView course(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("course");
        return mav;
    }
}
