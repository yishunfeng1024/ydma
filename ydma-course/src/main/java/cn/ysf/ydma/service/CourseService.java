package cn.ysf.ydma.service;

import cn.ysf.ydma.ysf.util.YdmaResult;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.service
 * @data 2020/4/27
 */
public interface CourseService {
    YdmaResult fiandCourse(int id);
    YdmaResult findSubjectLise(int subject_id,int page,int size);
    YdmaResult findDirectionList(int direction_id,int page,int size);
}
