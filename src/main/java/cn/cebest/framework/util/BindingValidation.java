package cn.cebest.framework.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


/**
 *  参数校验工具类
  * @author maming  
  * @date 2018年8月29日
 */

public class BindingValidation {

	
	/**
	 * @explain 参数校验
	 * @param bindingResult
	 * @return
	 */
	public static Result paramsValidation(BindingResult bindingResult){
		Result result = null;
		if(bindingResult.hasErrors()){  
	        ObjectError objectError =  bindingResult.getAllErrors().get(0);
	        FieldError fileError =  (FieldError) objectError;
	        ResultCode resultCode = ResultCode.PARAMETER_ERROR;
	        resultCode.setMessage(fileError.getField() +  objectError.getDefaultMessage());
			result = new Result(resultCode);
	    }
		return result;
	}
}
