package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect //切面类
@Component
public class LogAspect {
	//	这是spring框架自动交给ioc管理的
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private OperateLogMapper operateLogMapper;

	@Around("@annotation(com.itheima.anno.Log)")
	public Object recordLog(ProceedingJoinPoint pjp) throws Throwable {

//		操作人的Id 员工ID
		String token = request.getHeader("token");
		Map<String, Object> tokenMap = JwtUtils.checkToken(token);
		Integer id = (Integer) tokenMap.get("id");
//		操作时间
		LocalDateTime operateTime = LocalDateTime.now();
//		操作的类名
		String className = pjp.getClass().getName();
//		操作的方法名
		String methodName = pjp.getSignature().getName();
//		操作的参数
		String methodParams = Arrays.toString(pjp.getArgs());
//		操作的返回值

		long start = System.currentTimeMillis();
		Object proceed = pjp.proceed();
		long end = System.currentTimeMillis();
		String returnValue = JSONObject.toJSONString(proceed);
//		操作耗时
		long costTime = end - start;
		//		用于记录操作日记，创建记录对象
		OperateLog operateLog = new OperateLog(null, id, operateTime, className, methodName, methodParams, returnValue, costTime);
		operateLogMapper.insert(operateLog);
		return proceed;
	}
}
