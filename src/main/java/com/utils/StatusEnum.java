package com.utils;

import com.entelgy.pruebaentelgy.model.response.Status;

public enum StatusEnum {

    STATUS_FAIL("9999", "Ocurri\u00F3 un error en el proceso."),
    STATUS_SUCCESSFULL("0000", "El servicio se ha ejecutado de forma correcta.");
    
    private String code;
    private String message;

    private StatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
    }
    
    public Status create() {
		return new Status(this.code, this.message);
    }
    
    public boolean isCode(Status status) {
        return isCode(status.getCode());
    }

    public boolean isCode(String code) {
	    return this.code.equals(code);
	}
}
