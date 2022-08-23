package com.service.api.constant;

public class CommonConstant {
    private CommonConstant() {
        throw new IllegalStateException();
    }
    public static final Integer PAGE_SIZE = 10;
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_DELETE = "delete";
    public static final String APPLICATION_REQUEST_DETAIL = "REQUEST_DETAIL";
    public static final String FLAG_YES = "yes";
    public static final String FLAG_NO = "no";
    public static final String ACTION_TYPE_CREATE = "create";
    public static final String ACTION_TYPE_UPDATE = "update";
    public static final String ACTION_TYPE_DELETE = "delete";
    public static final String RESPONSE_SUCCESS = "success";
    public static final String RESPONSE_MESSAGE_SUCCESS = "request success";
    public static final String RESPONSE_CODE_SUCCESS = "200000";
    public static final String RESPONSE_FAIL = "fail";
    public static final String RESPONSE_MESSAGE_FAIL = "request fail";
    public static final String RESPONSE_CODE_FAIL = "500000";
}
