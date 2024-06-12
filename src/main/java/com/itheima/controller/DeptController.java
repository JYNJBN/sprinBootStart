package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;

	//	Logger logger = org.apache.logging.log4j.LogManager.getLogger(DeptController.class);
//	@RequestMapping(value = "/dept",method = RequestMethod.GET)
	@GetMapping()
	public Result list() {
		log.info("查询部门列表");
		List<Dept> deptList = deptService.list();
		return Result.success(deptList);
	}

	@Log

	//	事务管理
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable String id) throws Exception {
		log.info("删除部门");
		deptService.delete(id);
		return Result.success();
	}

	@Log

	@PostMapping()
	public Result add(@RequestBody Dept dept) {
		log.info("新增部门");
		deptService.add(dept);
		return Result.success();
	}

	@GetMapping("/{id}")
	public Result getListById(@PathVariable String id) {
		log.info("根据id查询部门");
		Dept dept = deptService.getListById(id);
		return Result.success(dept);
	}

	@Log
	@PutMapping()
	public Result update(@RequestBody Dept dept) {
		log.info("修改部门");
		deptService.update(dept);
		return Result.success();
	}
}
