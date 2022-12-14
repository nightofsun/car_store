package com.service.api.controller;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.ServiceNameConstant;
import com.service.api.model.rest.BaseRequest;
import com.service.api.model.rest.request.CreateNewCarRequest;
import com.service.api.model.rest.request.DeleteCarRequest;
import com.service.api.model.rest.request.GetCarListRequest;
import com.service.api.model.rest.request.UpdateCarRequest;
import com.service.api.model.rest.response.CreateNewCarResponse;
import com.service.api.model.rest.response.DeleteCarResponse;
import com.service.api.model.rest.response.GetCarListResponse;
import com.service.api.model.rest.response.UpdateCarResponse;
import com.service.api.service.CarService;
import com.service.api.service.LoggerService;
import com.service.api.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@CrossOrigin(ServiceNameConstant.SERVICE_CROSS_ORIGIN)
public class CarController extends CarControllerValidator{
    @Autowired
    private CarService carService;
    @Autowired
    private LoggerService loggerService;
    @PostMapping(ServiceNameConstant.SERVICE_GET_CAT_LIST)
    @ResponseBody
    public GetCarListResponse getCarList(@RequestAttribute(value = CommonConstant.APPLICATION_REQUEST_DETAIL)BaseRequest requestHeader) throws Exception {
        Date startDate = new Date();
        GetCarListResponse response;
        //1) Create request object from request string
        GetCarListRequest request = (GetCarListRequest) JSONUtils.transfromStringToObject(requestHeader.getBodyData(), GetCarListRequest.class);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,null);
        //2) validation request
        getCarListValidation(request);
        //3) Business begin
        response = carService.getCarList(requestHeader,request);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,response);
        //4) return data
        return response;
    }

    @PostMapping(ServiceNameConstant.SERVICE_CREATE_NEW_CAR)
    @ResponseBody
    public CreateNewCarResponse createNewCar(@RequestAttribute(value = CommonConstant.APPLICATION_REQUEST_DETAIL)BaseRequest requestHeader) throws Exception {
        Date startDate = new Date();
        CreateNewCarResponse response;
        //1) Create request object from request string
        CreateNewCarRequest request = (CreateNewCarRequest) JSONUtils.transfromStringToObject(requestHeader.getBodyData(), CreateNewCarRequest.class);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,null);
        //2) validation request
        createNewCarValidation(request);
        //3) Business begin
        response = carService.createNewCar(requestHeader,request);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,response);
        //4) return data
        return response;
    }
    @PostMapping(ServiceNameConstant.SERVICE_UPDATE_CAR)
    @ResponseBody
    public UpdateCarResponse updateCar(@RequestAttribute(value = CommonConstant.APPLICATION_REQUEST_DETAIL)BaseRequest requestHeader) throws Exception {
        Date startDate = new Date();
        UpdateCarResponse response;
        //1) Create request object from request string
        UpdateCarRequest request = (UpdateCarRequest) JSONUtils.transfromStringToObject(requestHeader.getBodyData(), UpdateCarRequest.class);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,null);
        //2) validation request
        updateCarValidation(request);
        //3) Business begin
        response = carService.updateCar(requestHeader,request);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,response);
        //4) return data
        return response;
    }
    @PostMapping(ServiceNameConstant.SERVICE_DELETE_CAR)
    @ResponseBody
    public DeleteCarResponse deleteCar(@RequestAttribute(value = CommonConstant.APPLICATION_REQUEST_DETAIL)BaseRequest requestHeader) throws Exception {
        Date startDate = new Date();
        DeleteCarResponse response;
        //1) Create request object from request string
        DeleteCarRequest request = (DeleteCarRequest) JSONUtils.transfromStringToObject(requestHeader.getBodyData(), DeleteCarRequest.class);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,null);
        //2) validation request
        deleteCarValidation(request);
        //3) Business begin
        response = carService.deleteCar(requestHeader,request);
        loggerService.accessLogger(startDate,new Date(),requestHeader.getRequestURI(),request,response);
        //4) return data
        return response;
    }
}
