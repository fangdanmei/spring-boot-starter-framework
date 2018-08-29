package cn.cebest.framework.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  返回对象
 * @author maming
 * @date 2018年8月29日
 */
@Setter
@Getter
@AllArgsConstructor
public class Result {

	// 状态码
	private Integer code;

	// 描述
	private String message;

	// 返回数据
	private Object data;

	public Result() {
		this.code = ResultCode.SUCCESS.code;
		this.message = ResultCode.SUCCESS.message;
	}

	public Result(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}
	
	public Result(ResultCode resultCode, Object data){
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.data = data;
	}

}
