package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {


	public void deleteByIds(List<Integer> ids);

//	Emp list(Emp emp, Page page);

	Long getListCount();

	List<Emp> list(EmpPage empPage);

	void save(Emp emp);

	Emp getEmpById(String id);

	void update(Emp emp);

	Emp getEmpByuserNameAndPassword(Emp emp);

	void deleteByDeptId(String id);
}
