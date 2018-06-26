package org.edi.stocktask.util;

/**
 * Created by asus on 2018/6/25.
 */

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class myCORSFilter implements Filter{
    @Override public void init(FilterConfig filterConfig) throws ServletException {


    }
    @Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "authentication,origin,accept,x-requested-with,content-type,access-token");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override public void destroy() {


    }


}
