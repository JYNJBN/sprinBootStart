package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
	void insert(DeptLog deptLog);
}
