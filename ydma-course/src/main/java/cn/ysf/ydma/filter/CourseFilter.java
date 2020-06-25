package cn.ysf.ydma.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.ysf.ydma.filter
 * @data 2020/6/5
 */
@WebFilter(filterName = "coursefilter",servletNames = {"dispatcherServlet"})
public class CourseFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httResponse = (HttpServletResponse) response;
        //允许访问的域名
        httResponse.setHeader("Access-Control-Allow-Origin","*");
        //允许提交的方式
        httResponse.setHeader("Access-Control-Allow-Methods","get,post,put,delete");
        chain.doFilter(request, response);
    }
}
