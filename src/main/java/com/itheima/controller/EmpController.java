package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpPage;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpService empService;

	@GetMapping()
	public Result list(EmpPage empPage) {
		log.info("查询员工信息，分页条件：{}", empPage);
		PageBean pageBean = empService.list(empPage);
		return Result.success(pageBean);
	}

	@Log
	@DeleteMapping("/{ids}")
	public Result delete(@PathVariable List<Integer> ids) {
		log.info("批量删除，id列表：{}", ids);
		empService.delete(ids);
		return Result.success();
	}

	@Log
	@PostMapping()
	public Result save(@RequestBody Emp emp) {
		log.info("新增员工，员工信息：{}", emp);
		empService.save(emp);
		return Result.success();
	}

	@GetMapping("/{id}")
	public Result getEmpById(@PathVariable String id) {
		log.info("根据id查询emp");
		Emp emp = empService.getEmpById(id);
		return Result.success(emp);
	}

	@Log
	@PutMapping()
	public Result update(@RequestBody Emp emp) {
		log.info("修改员工信息：{}", emp);
		empService.update(emp);
		return Result.success();
	}
}
