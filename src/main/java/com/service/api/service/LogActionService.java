package com.service.api.service;

public interface LogActionService {
    public void createNewCarLog(String carID, String carAttribute) throws Exception;
    public void updateCarLog(String carID, String carAttributeBefore, String carAttributeAfter) throws Exception;
    public void deleteCarLog(String carID) throws Exception;
}
