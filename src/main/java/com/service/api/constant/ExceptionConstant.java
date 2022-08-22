package com.service.api.constant;

public class ExceptionConstant {
    private ExceptionConstant() {
        throw new IllegalStateException();
    }
    public static final String DATABASE_EXCEPTION = "100000";
    public static final String SERVICE_VALIDATION_EXCEPTION = "200000";
}
