package com.service.api.constant;

public class ServiceNameConstant {
    private ServiceNameConstant() {
        throw new IllegalStateException();
    }
    public static final String SERVICE_GET_CAT_LIST = "/getCarList";
    public static final String SERVICE_CREATE_NEW_CAR = "/createNewCar";
    public static final String SERVICE_UPDATE_CAR = "/updateCar";
    public static final String SERVICE_DELETE_CAR = "/deleteCar";
}
