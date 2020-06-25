package cn.ysf.ydma.service;

import cn.ysf.ydma.ysf.util.YdmaResult;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.service
 * @data 2020/4/23
 */
//@Service
public interface UserService {
    YdmaResult addUser(String name, String password);
    YdmaResult checkUser(String name,String password);
    YdmaResult findOne(int id);
}
