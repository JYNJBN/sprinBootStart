package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
	List<Dept> list();

	void delete(String id) throws Exception;

	void add(Dept dept);

	Dept getListById(String id);

	void update(Dept dept);
}
