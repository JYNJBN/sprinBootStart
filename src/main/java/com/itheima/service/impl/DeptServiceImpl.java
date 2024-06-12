package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private DeptLogServiceImpl deptLogService;

	@Override
	public List<Dept> list() {
		return deptMapper.list();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(String id) throws Exception {
		try {
			deptMapper.deleteById(id);
//		int a = 1 / 0;
			if (true) {
				throw new Exception("出错了");
			}
			empMapper.deleteByDeptId(id);
		} finally {
			DeptLog deptLog = new DeptLog("删除部门" + id, LocalDateTime.now(), LocalDateTime.now());
//			无论成功失败都插入数据到log表
			deptLogService.insert(deptLog);

		}
	}

	@Override
	public void add(Dept dept) {
		dept.setCreateTime(LocalDateTime.now());
		dept.setUpdateTime(LocalDateTime.now());
		deptMapper.add(dept);
	}

	@Override
	public Dept getListById(String id) {
		return deptMapper.getListById(id);
	}

	@Override
	public void update(Dept dept) {
		deptMapper.update(dept);
	}
}
