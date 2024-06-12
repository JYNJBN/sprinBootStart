package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override //在请求处理之前进行调用（Controller方法调用之前）
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

//		判断是否有token
		if (StringUtils.isEmpty(req.getHeader("token"))) {
			Result result = Result.error("NOT_LOGIN", "NOT_LOGIN");
			String error = JSONObject.toJSONString(result);
			resp.getWriter().write(error);
			return false;
		}
		try {
			String token = req.getHeader("token");
			JwtUtils.checkToken(req.getHeader("token"));
		} catch (Exception e) {
//			token解析错误
			Result result = Result.error("NOT_LOGIN", "NOT_LOGIN");
			String error = JSONObject.toJSONString(result);
			resp.getWriter().write(error);
			return false;
		}
//		校验通过
		return true;
	}

	@Override //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("afterCompletion");
	}
}
