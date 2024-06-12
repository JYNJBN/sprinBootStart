package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
	@Override
//	初始化只执行一次
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化");
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//		登录请求不需要校验token
		if (req.getRequestURL().toString().contains("login")) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
//		判断是否有token
		if (StringUtils.isEmpty(req.getHeader("token"))) {
			Result result = Result.error("NOT_LOGIN", "NOT_LOGIN");
			String error = JSONObject.toJSONString(result);
			resp.getWriter().write(error);
			return;
		}
		try {
			String token = req.getHeader("token");
			JwtUtils.checkToken(req.getHeader("token"));
		} catch (Exception e) {
//			token解析错误
			Result result = Result.error("NOT_LOGIN", "NOT_LOGIN");
			String error = JSONObject.toJSONString(result);
			resp.getWriter().write(error);
			return;
		}
//		校验通过
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
//	销毁只执行一次
	public void destroy() {
		System.out.println("销毁");
		Filter.super.destroy();
	}
}
