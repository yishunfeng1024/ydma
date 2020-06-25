package cn.ysf.ydma.web;

import cn.ysf.ydma.service.DirectionService;
import cn.ysf.ydma.ysf.util.YdmaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.web
 * @data 2020/4/29
 */
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class DirectionController {
    @Autowired
    private DirectionService service;
    @GetMapping("/direction/all")
    public YdmaResult findall(){
        return service.findAll();
    }
}
