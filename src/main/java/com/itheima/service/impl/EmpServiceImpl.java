package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpPage;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;


	@Override
	public PageBean list(EmpPage empPage) {
//		empPage.setPage((empPage.getPage()-1)*empPage.getPageSize());
//		List<Emp> empList=empMapper.list(empPage);
//		Long total=empMapper.getListCount();
//		分页
		PageHelper.startPage(empPage.getPage(), empPage.getPageSize());
		List<Emp> empList = empMapper.list(empPage);
		Page<Emp> page = (Page<Emp>) empList;
		return new PageBean(page.getTotal(), page.getResult());
	}

	@Override
	public void delete(List<Integer> ids) {
		empMapper.deleteByIds(ids);
	}

	@Override
	public void save(Emp emp) {
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.save(emp);
	}

	@Override
	public Emp getEmpById(String id) {
		return empMapper.getEmpById(id);
	}

	@Override
	public void update(Emp emp) {
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.update(emp);
	}

	@Override
	public Emp getEmpByuserNameAndPassword(Emp emp) {
		Emp emp1 = empMapper.getEmpByuserNameAndPassword(emp);
		return emp1;
	}

	@Override
	public void deleteByDeptId(String id) {
		empMapper.deleteByDeptId(id);
	}


}
