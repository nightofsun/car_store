package com.service.api.constant;

public class ExceptionConstant {
    private ExceptionConstant() {
        throw new IllegalStateException();
    }
    public static final String SERVICE_VALIDATION_EXCEPTION_MESSAGE = "service validation request fail";
    public static final String SERVICE_EXCEPTION_MESSAGE = "service request fail";
    public static final String COMMON_EXCEPTION = "500000";

    public static final String DATABASE_EXCEPTION = "501000";
    public static final String SERVICE_EXCEPTION = "502000";
    public static final String SERVICE_VALIDATION_EXCEPTION = "400000";
    public static final String NOT_FOUND_EXCEPTION = "404000";
    public static final String PAGE_NUMBER_MISSING = "400001";
    public static final String PAGE_NUMBER_INVALID_TYPE = "400002";
    public static final String MIN_PRICE_INVALID_TYPE = "400003";
    public static final String MAX_PRICE_INVALID_TYPE = "400004";
    public static final String SORT_TYPE_MISSING = "400005";
    public static final String SORT_TYPE_INVALID_TYPE = "400006";
    public static final String CAR_BRAND_MISSING = "400007";
    public static final String CAR_BRAND_INVALID = "400008";
    public static final String CAR_NAME_MISSING = "400009";
    public static final String CAR_NAME_INVALID = "400010";
    public static final String CAR_DRIVE_SYSTEM_INVALID = "400011";
    public static final String CAR_GEAR_TYPE_MISSING = "400012";
    public static final String CAR_GEAR_TYPE_INVALID = "400013";
    public static final String CAR_YEAR_MISSING = "400014";
    public static final String CAR_YEAR_INVALID = "400015";
    public static final String CAR_ENGIN_INVALID = "400016";
    public static final String CAR_PRICE_MISSING = "400017";
    public static final String CAR_PRICE_INVALID = "400018";
    public static final String CAR_CAR_TYPE_INVALID = "400019";
    public static final String CAR_OIL_TYPE_INVALID = "400020";
    public static final String CAR_ID_MISSING = "400021";
    public static final String CAR_ID_INVALID = "400022";
}
