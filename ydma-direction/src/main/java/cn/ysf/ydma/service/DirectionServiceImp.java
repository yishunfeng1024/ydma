package cn.ysf.ydma.service;

import cn.ysf.ydma.ysf.util.YdmaConstant;
import cn.ysf.ydma.ysf.util.YdmaResult;
import cn.ysf.ydma.dao.DirectionMapper;
import cn.ysf.ydma.dao.SubjectMapper;
import cn.ysf.ydma.entity.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.service
 * @data 2020/4/29
 */
@Service
public class DirectionServiceImp implements DirectionService {
    @Autowired
    private DirectionMapper dao;
    @Autowired
    private SubjectMapper subdao;
    @Autowired
    private RestTemplate restTemplate;
    public YdmaResult findAll() {
        YdmaResult ydmaResult = new YdmaResult();
        //通过Mybatis关联查询，查询出了Direction信息和subject信息
        List<Direction> list = dao.selectAll();
        //循环为每一个Direction大类别加载对应的推荐课信息
        for (Direction d:list) {
        //调用http://localhost:7002/course/direction?direction_id=?服务
           // System.out.println(d.getId());
            String url = "http://localhost:7002/course/direction?direction_id="+d.getId();
            YdmaResult yyCourse = restTemplate.getForObject(url,YdmaResult.class);
            //System.out.println(yyCourse.getMsg()+"???"+YdmaConstant.FIND_SUCCESS);
            if (yyCourse.getMsg().equals(YdmaConstant.FIND_SUCCESS)){
               List courses =  (List) yyCourse.getData();
               d.setCourses(courses);
            }
        }
        ydmaResult.setCode(YdmaConstant.SUCCESS);
        ydmaResult.setMsg(YdmaConstant.FIND_SUCCESS);
        ydmaResult.setData(list);
        System.out.println("长度"+list.size()+":"+list.get(2).getName()+":"+list.get(2).getCourses());
        return ydmaResult;
    }
}
