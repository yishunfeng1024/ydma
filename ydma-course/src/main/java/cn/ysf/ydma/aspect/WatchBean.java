package cn.ysf.ydma.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.aspect
 * @data 2020/5/13
 */
@Component
@Aspect
public class WatchBean {
    @Around("within(cn.ysf.ydma.service..*)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //整一个定时器
        StopWatch watch = new StopWatch();
        watch.start();
        //执行连接点关联的目标对象
        Object object = pjp.proceed();
        watch.stop();
        System.out.println("执行时间:"+watch.getTotalTimeMillis()+"ms");
        return object;
    }
}
