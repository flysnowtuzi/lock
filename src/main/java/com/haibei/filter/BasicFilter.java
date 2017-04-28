package com.haibei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
public class BasicFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest,  ServletResponse servletResponse, FilterChain filterchain)
			throws IOException, ServletException {

     HttpServletResponse response = (HttpServletResponse) servletResponse;

 

//指定允许其他域名访问  

 response.addHeader("Access-Control-Allow-Origin", "*");

//2 响应类型  响应方法

 response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS"); 

   // 响应头设置 

 response.addHeader("Access-Control-Allow-Headers", "POWERED-BY-FANTONG");

 response.addHeader("Access-Control-Max-Age", "30");   
 
 
 // 需要过滤的代码
 filterchain.doFilter(servletRequest, servletResponse);
}

    public void init(FilterConfig config) throws ServletException {

    }
}
