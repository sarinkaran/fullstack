package com.sapient.fullstack.refData.exceptions;

import java.io.Serializable;

public interface ExceptionMessage extends Serializable {
	
	public final static String HTTP_CODE_PREFIX= "exception.http_code.";
	public final static String HTTP_MESSAGE_PREFIX="exception.message.";
	
	String getErrorMessage();
	
	int getErrorCode();
	
	String getDefaultMessage();
	
	Throwable getCause();

    String getInterpolatedMessage(String message);
	
	

}
