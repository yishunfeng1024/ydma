package cn.ysf.ydma.service;

import cn.ysf.ydma.util.JWTUtil;
import cn.ysf.ydma.util.PasswordUtil;
import cn.ysf.ydma.ysf.util.YdmaConstant;
import cn.ysf.ydma.ysf.util.YdmaResult;
import cn.ysf.ydma.dao.UserMapper;
import cn.ysf.ydma.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.service
 * @data 2020/4/23
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userDao;
    public YdmaResult addUser(String name, String password) {
        //查询用户是否存在
        YdmaResult ydmaResult = new YdmaResult();
        User user = userDao.selectByName(name);
        if (user!=null){
            ydmaResult.setCode(YdmaConstant.ERROR);
            ydmaResult.setMsg(YdmaConstant.REGIST_ERROR1);
            return  ydmaResult;
        }else {
            User user2 = new User();
            user2.setName(name);
            //密码进行加密处理
            String salt = PasswordUtil.salt();
            String newPassword = PasswordUtil.md5(password+salt);
            user2.setSalt(salt);
            user2.setPassword(newPassword);
            user2.setRegtime(new Date());
            userDao.insertSelective(user2);
            ydmaResult.setCode(YdmaConstant.SUCCESS);
            ydmaResult.setMsg(YdmaConstant.REGIST_SUCCESS);
            return ydmaResult;
        }
    }
    /**登陆检查**/
    public YdmaResult checkUser(String name, String password) {
        YdmaResult ydmaResult = new YdmaResult();
        //去数据库查用户是否存在
        User user = userDao.selectByName(name);
        //判断是用户不存在 还是密码错误 还是都正确颁发令牌
        if (null==user){
            ydmaResult.setCode(YdmaConstant.ERROR);
            ydmaResult.setMsg(YdmaConstant.LOGIN_ERROR1);
            return ydmaResult;
        }
            String md5password = PasswordUtil.md5(password+user.getSalt());
        if (!user.getPassword().equals(md5password)){
            ydmaResult.setCode(YdmaConstant.ERROR2);
            ydmaResult.setMsg(YdmaConstant.LOGIN_ERROR2);
            return ydmaResult;
        }
        //如果正确颁发token令牌
        String token = JWTUtil.sign(user);
        ydmaResult.setCode(YdmaConstant.SUCCESS);
        ydmaResult.setMsg(YdmaConstant.LOGIN_SUCCESS);
        //颁发令牌
       ydmaResult.setData(token);
        return ydmaResult;
    }
    /**根据ID查询一个用户 并且屏蔽掉密码**/
    public YdmaResult findOne(int id) {
        YdmaResult ydmaResult = new YdmaResult();
        User user = userDao.selectByPrimaryKey(id);
        if (null != user) {
            user.setPassword(null);
            ydmaResult.setCode(YdmaConstant.SUCCESS);
            ydmaResult.setMsg(YdmaConstant.FIND_SUCCESS);
            ydmaResult.setData(user);
            return ydmaResult;
        } else
            ydmaResult.setCode(YdmaConstant.ERROR);
            ydmaResult.setMsg(YdmaConstant.FIND_ERROR);
            return ydmaResult;
    }
}
