package cn.ysf.ydma.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma.ysf.ydma.filter
 * @data 2020/6/6
 */
@WebFilter(filterName = "userFilter",servletNames = {"dispatcherServlet"})
public class UserFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain
            chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods","get,post,put,delete");
        chain.doFilter(request, response);
    }
}
