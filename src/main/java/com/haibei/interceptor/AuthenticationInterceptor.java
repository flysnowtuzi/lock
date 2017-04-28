package com.haibei.interceptor;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;

public class AuthenticationInterceptor implements HandlerInterceptor {
	/**
	 * 
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("SecurityInterceptor preHandle:" + request.getContextPath() + "," + request.getRequestURI()
				+ "," + request.getMethod());

		// handler.toString();
		// handler.getClass().getMethod(name, parameterTypes)

		// 参数
		Map<String, String[]> paramMap = request.getParameterMap();
		// 打印错误返回
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		if (checkParam(paramMap, resMap)) {
			
			if (checkPermission(handler)) {
				
				return true;
			}else{
				 resMap.put("statusCode", "300");
				 resMap.put("message","未授权");
				return false;
			}
			
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(resMap));
			out.flush();
			out.close();
			return false;
		}
	}

	/*
	 * 参数检测 Map<String,String[]> paramMap 参数 Map<String,Object> resMap 返回
	 */
	private boolean checkParam(Map<String, String[]> paramMap, Map<String, Object> resMap) {
		if (paramMap.get("sysId") == null) {
			resMap.put("statusCode", "400");
			resMap.put("message", "请输入sysId");
			return false;
		}

		return true;
	}

	/*
	 * 参数用户是否有改方法权限 Map<String,String[]> paramMap 参数 Map<String,Object> resMap
	 * 返回
	 */
	private boolean checkPermission(Object handler) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			System.out.println(method.getBeanType().getName()); //类名称
			System.out.println(method.getMethod().getName()); //实际方法名称
			Annotation[] anArray = method.getMethod().getDeclaredAnnotations();
			//int i = 0;
			for (Annotation an : anArray) {
				if (an instanceof RequestMapping) {
					RequestMapping rm = (RequestMapping) an;
					System.out.println(String.valueOf(rm.value())); //注释的方法名称
					//StringUtils.collectionToDelimitedString(rm.value())
					System.out.println(com.haibei.util.string.StringUtils.ArrayToString(rm.value()));
					break;
				}
			}
			

		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}