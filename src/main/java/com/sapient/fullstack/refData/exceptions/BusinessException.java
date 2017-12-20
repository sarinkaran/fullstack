package com.sapient.fullstack.refData.exceptions;

import com.sapient.fullstack.refData.Model.BusinessError;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private BusinessError detail;

    public BusinessException(BusinessError detail) {
    	
        super(detail.getDefaultMessage());
        this.detail = detail;
    }

    public BusinessException(String code, Object... args) {
        
    	this(BusinessError.error(code, args));
    }

    public BusinessError getDetail() {
        return this.detail;
    }

}
