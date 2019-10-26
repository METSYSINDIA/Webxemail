package com.webxmail.common.Util;

public class FieldErrorUtil {
	public String fieldError;
	 public String fieldErrorMsg;
	 
public	FieldErrorUtil(String fieldError,String fieldErrorMsg) {
	this.fieldError=fieldError;
	this.fieldErrorMsg=fieldErrorMsg;
}
 public String getFieldError() {
		return fieldError;
	}
	public void setFieldError(String fieldError) {
		this.fieldError = fieldError;
	}
	public String getFieldErrorMsg() {
		return fieldErrorMsg;
	}
	public void setFieldErrorMsg(String fieldErrorMsg) {
		this.fieldErrorMsg = fieldErrorMsg;
	}


}
