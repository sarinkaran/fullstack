package com.sapient.fullstack.refData.Model;

import java.text.MessageFormat;
import java.util.function.Supplier;

import com.sapient.fullstack.refData.exceptions.ExceptionMessage;

public class BusinessError implements ExceptionMessage {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private Object[] args;

	private BusinessError(String errorCode, Object... args) {
		this.errorCode = errorCode;
		this.args = args;
	}

	public static Supplier<BusinessError> supplyError(String errorCode, Object... args) {
		return () -> new BusinessError(errorCode, args);
	}

	public static BusinessError error(String errorCode, Object... args) {
		return new BusinessError(errorCode, args);
	}

	@Override
	public String getErrorMessage() {
		return HTTP_MESSAGE_PREFIX + errorCode;
	}

	@Override
	public int getErrorCode() {
		return 0;
	}

	@Override
	public String getDefaultMessage() {
		return errorCode;
	}

	public Throwable getCause() {
		return null;
	}

	@Override
	public String getInterpolatedMessage(String message) {
		return args == null && args.length == 0 ? message : MessageFormat.format(message, args);
	}
}
