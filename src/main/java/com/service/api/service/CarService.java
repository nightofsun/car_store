package com.service.api.service;

import com.service.api.model.rest.BaseRequest;
import com.service.api.model.rest.request.CreateNewCarRequest;
import com.service.api.model.rest.request.DeleteCarRequest;
import com.service.api.model.rest.request.GetCarListRequest;
import com.service.api.model.rest.request.UpdateCarRequest;
import com.service.api.model.rest.response.CreateNewCarResponse;
import com.service.api.model.rest.response.DeleteCarResponse;
import com.service.api.model.rest.response.GetCarListResponse;
import com.service.api.model.rest.response.UpdateCarResponse;


public interface CarService {
    public GetCarListResponse getCarList(BaseRequest requestHeader, GetCarListRequest request) throws Exception;
    public CreateNewCarResponse createNewCar(BaseRequest requestHeader, CreateNewCarRequest request) throws Exception;
    public UpdateCarResponse updateCar(BaseRequest requestHeader, UpdateCarRequest request) throws Exception;
    public DeleteCarResponse deleteCar(BaseRequest requestHeader, DeleteCarRequest request) throws Exception;
}
