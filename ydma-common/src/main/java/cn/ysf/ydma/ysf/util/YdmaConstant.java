package cn.ysf.ydma.ysf.util;

import java.io.Serializable;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.entity
 * @data 2020/4/26
 */
public class YdmaConstant implements Serializable {
    public static final int SUCCESS =0;
    public static final int ERROR = 1;
    public static final int ERROR1 = 2;
    public static final int ERROR2 = 3;
    public static final String REGIST_SUCCESS = "注册成功";
    public static final String REGIST_ERROR1="用户名已经存在";
    public static final String LOGIN_ERROR1="用户不存在";
    public static final String LOGIN_ERROR2="密码错误";
    public static final String LOGIN_SUCCESS="登陆成功";
    public static final String FIND_SUCCESS="查找成功";
    public static final String FIND_ERROR="查找失败";
}
