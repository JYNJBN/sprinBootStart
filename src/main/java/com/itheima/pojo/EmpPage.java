package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpPage {
	private Integer id; //ID
	private String username; //用户名
	private String password; //密码
	private String name; //姓名
	private Short gender; //性别 , 1 男, 2 女
	private String image; //图像url
	private Short job; //职位 , 1 班主任 , 2 讲师 , 3 学工主管 , 4 教研主管 , 5 咨询师
	private LocalDate entrydate; //入职日期
	private Integer deptId; //部门ID
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate begin; //创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end; //修改时间
	private Integer page;
	private Integer pageSize;
}
