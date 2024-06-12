package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")

public class LoginController {
	@Autowired
	private EmpService empService;

	@PostMapping("")
	public Result login(@RequestBody Emp emp) {
		Emp emp1 = empService.getEmpByuserNameAndPassword(emp);
		if (emp1 != null) {
			Map<String, Object> clamis = new HashMap<>();
			clamis.put("id", emp1.getId());
			clamis.put("username", emp1.getUsername());
			clamis.put("name", emp1.getName());
			String token = JwtUtils.createToken(clamis);
			return Result.success(token);
		} else {
			return Result.error("用户名或密码错误");
		}
	}
}
