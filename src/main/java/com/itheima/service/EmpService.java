package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpPage;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
	static void deleteByIds(List<Integer> ids) {
	}

	PageBean list(EmpPage empPage);

	void delete(List<Integer> ids);

	void save(Emp emp);

	Emp getEmpById(String id);

	void update(Emp emp);

	Emp getEmpByuserNameAndPassword(Emp emp);

	void deleteByDeptId(String id);
}
