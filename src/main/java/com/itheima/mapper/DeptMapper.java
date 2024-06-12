package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
	public List<Dept> list();
	public void deleteById(String id);

	public void add(Dept dept);

	Dept getListById(String id);

	void update(Dept dept);
}
