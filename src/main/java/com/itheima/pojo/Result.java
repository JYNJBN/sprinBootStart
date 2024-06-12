package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	private Integer code;
	private String msg;
	private Object data;

	public static Result success() {
		return new Result(1, "success", null);
	}

	public static Result success(Object object) {
		return new Result(1, "success", object);
	}

	public static Result error(Object object) {
		return new Result(0, "error", object);
	}

	public static Result error(String msg, Object object) {
		return new Result(0, msg, object);
	}

}
