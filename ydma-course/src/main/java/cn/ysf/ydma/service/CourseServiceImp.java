package cn.ysf.ydma.service;

import cn.ysf.ydma.ysf.util.YdmaConstant;
import cn.ysf.ydma.ysf.util.YdmaResult;
import cn.ysf.ydma.dao.CourseMapper;
import cn.ysf.ydma.entity.Course;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.service
 * @data 2020/4/27
 */
@Service
public class CourseServiceImp implements CourseService{
    @Autowired
    private CourseMapper dao;
    @Autowired
    private RedisTemplate<Object,Object> redis;
    public YdmaResult fiandCourse(int id) {
        YdmaResult ydmaResult = new YdmaResult();
        //先查Redis
        String key = "course:"+id;
        Course course = (Course) redis.opsForValue().get(key);
        //没有查询db
        if(null==course){
            course = dao.selectByPrimaryKey(id);
            //并将数据放入redis
            redis.opsForValue().set(key,course);
        }
        //返回结果
        if (null!=course){
            ydmaResult.setCode(YdmaConstant.SUCCESS);
            ydmaResult.setMsg(YdmaConstant.FIND_SUCCESS);
            ydmaResult.setData(course);
            return ydmaResult;
        }
            else {
            ydmaResult.setCode(YdmaConstant.ERROR);
            ydmaResult.setMsg(YdmaConstant.FIND_ERROR);
            return ydmaResult;
        }
    }
   // @Cacheable(value = "subjects")//针对整个方法的缓存
    public YdmaResult findSubjectLise(int subject_id,int page,int size) {
        YdmaResult ydmaResult = new YdmaResult();
       List<Course> list =dao.selectBySubject_id(subject_id);
       if (list.isEmpty()){
           ydmaResult.setCode(YdmaConstant.ERROR);
           ydmaResult.setMsg(YdmaConstant.FIND_ERROR);
           //System.out.println("失败");
           return ydmaResult;
       }
        ydmaResult.setCode(YdmaConstant.SUCCESS);
        ydmaResult.setMsg(YdmaConstant.FIND_SUCCESS);
        ydmaResult.setData(list);
        //System.out.println("成功");
        return ydmaResult;
    }
    //@CacheEvict(beforeInvocation = true)
    //@Cacheable(value = "DirectionCourses")//针对整个方法的缓存
    public YdmaResult findDirectionList(int direction_id, int page, int size) {
        YdmaResult ydmaResult = new YdmaResult();
        PageHelper.startPage(page,size);
        List<Course> list =dao.selectByDirection_id(direction_id);
        if (list.isEmpty()){
            ydmaResult.setCode(YdmaConstant.ERROR);
            ydmaResult.setMsg(YdmaConstant.FIND_ERROR);
            //ystem.out.println("失败");
            return ydmaResult;
        }
        ydmaResult.setCode(YdmaConstant.SUCCESS);
        ydmaResult.setMsg(YdmaConstant.FIND_SUCCESS);
        ydmaResult.setData(list);
        //System.out.println("成功");
        return ydmaResult;
    }

}
