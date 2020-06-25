package cn.ysf.ydma.web;

import cn.ysf.ydma.service.CourseService;
import cn.ysf.ydma.ysf.util.YdmaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.web
 * @data 2020/4/26
 */
@RestController
//解决ajax跨域问题
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping ("/course/list")
    public YdmaResult loadCourse(int id){
        return service.fiandCourse(id);
    }
    @GetMapping("/course/subject")
    public YdmaResult loadSubject(int subject_id,
            @RequestParam(name="page",required = false,defaultValue = "1")int page ,
            @RequestParam(name="size",required = false,defaultValue = "3") int size){
        return service.findSubjectLise(subject_id,page,size);
    }
    @GetMapping("/course/direction")
    public YdmaResult loadDirection(int direction_id,
                                  @RequestParam(name="page",required = false,defaultValue = "1")int page ,
                                  @RequestParam(name="size",required = false,defaultValue = "3") int size){
        return service.findDirectionList(direction_id,page,size);
    }
}
