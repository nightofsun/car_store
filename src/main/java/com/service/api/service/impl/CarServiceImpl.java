package com.service.api.service.impl;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.DateTimeConstant;
import com.service.api.constant.ExceptionConstant;
import com.service.api.dao.CarDao;
import com.service.api.domain.Car;
import com.service.api.exceptions.DatabaseException;
import com.service.api.exceptions.ServiceException;
import com.service.api.model.rest.BaseRequest;
import com.service.api.model.rest.request.CreateNewCarRequest;
import com.service.api.model.rest.request.DeleteCarRequest;
import com.service.api.model.rest.request.GetCarListRequest;
import com.service.api.model.rest.request.UpdateCarRequest;
import com.service.api.model.rest.response.*;
import com.service.api.service.CarService;
import com.service.api.service.LogActionService;
import com.service.api.util.DateUtils;
import com.service.api.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private LogActionService logActionService;
    @Override
    public GetCarListResponse getCarList(BaseRequest requestHeader, GetCarListRequest request) throws Exception {
        Date currentDate = new Date();
        GetCarListResponse response = new GetCarListResponse();
        List<CarAttribute> carAttributeList = new ArrayList<>();
        try {
            Car car = new Car();
            car.setName(request.getName());
            car.setGearType(request.getGearType());
            car.setCarType(request.getCarType());
            car.setBrand(request.getBrand());
            car.setIsDelete(CommonConstant.FLAG_NO);
            int page = Integer.parseInt(request.getPage());
            int count = carDao.getCount(car, request.getMinPrice(), request.getMaxPrice());
            List<Car> carList = carDao.find(car, request.getMinPrice(), request.getMaxPrice(), request.getSortType(), page);
            if(carList!=null && carList.size()>0){
                for (Car tempCar: carList) {
                    CarAttribute carAttribute = new CarAttribute();
                    carAttribute.setCarId(tempCar.getCarID());
                    carAttribute.setBrand(tempCar.getBrand());
                    carAttribute.setName(tempCar.getName());
                    carAttribute.setEngine(tempCar.getEngine());
                    carAttribute.setYear(tempCar.getYear());
                    carAttribute.setCarType(tempCar.getCarType());
                    carAttribute.setPrice(tempCar.getPrice());
                    carAttribute.setDriveSystem(tempCar.getDriveSystem());
                    carAttribute.setOilType(tempCar.getOilType());
                    carAttributeList.add(carAttribute);
                }
            }
            int totalPage = (int) Math.ceil(count/(CommonConstant.PAGE_SIZE*1.0));
            int startAt = ((page-1)*CommonConstant.PAGE_SIZE)+1;
            int endAt = (page*CommonConstant.PAGE_SIZE<count)?page*CommonConstant.PAGE_SIZE: count;
            if (page>totalPage){
                startAt = 0;
                endAt = 0;
            }
            response.setCarList(carAttributeList);
            response.setCarCount(count);
            response.setStartAt(startAt);
            response.setEndAt(endAt);
            response.setTotalPage(totalPage);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw e;
        }
        response.setTimestamp(DateUtils.formatDateToString(currentDate, DateTimeConstant.APPLICATION_DATE_FORMAT));
        response.setStatus(CommonConstant.RESPONSE_SUCCESS);
        response.setStatusCode(CommonConstant.RESPONSE_CODE_SUCCESS);
        response.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
        return response;
    }

    @Override
    public CreateNewCarResponse createNewCar(BaseRequest requestHeader, CreateNewCarRequest request) throws Exception {
        Date currentDate = new Date();
        CreateNewCarResponse response = new CreateNewCarResponse();
        try {
            Car newCar = new Car();
            newCar.setCarID(UUID.randomUUID().toString());
            newCar.setIsDelete(CommonConstant.FLAG_NO);
            newCar.setCreateAt(currentDate);
            newCar.setBrand(request.getBrand());
            newCar.setName(request.getName());
            newCar.setDriveSystem(request.getDriveSystem());
            newCar.setGearType(request.getGearType());
            newCar.setEngine(request.getEngine());
            newCar.setCarType(request.getCarType());
            newCar.setOilType(request.getOilType());
            if (StringUtils.isNotEmtyOrNull(request.getYear())) {
                newCar.setYear(Integer.parseInt(request.getYear()));
            }
            if (StringUtils.isNotEmtyOrNull(request.getPrice())) {
                newCar.setPrice(Integer.parseInt(request.getPrice()));
            }
            List<Car> createList = new ArrayList<>();
            createList.add(newCar);
            carDao.insert(createList);
            logActionService.createNewCarLog(newCar.getCarID(),newCar.toString());
            response.setStatus(CommonConstant.RESPONSE_SUCCESS);
            response.setStatusCode(CommonConstant.RESPONSE_CODE_SUCCESS);
            response.setTimestamp(DateUtils.formatDateToString(currentDate,DateTimeConstant.APPLICATION_DATE_FORMAT));
            response.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw new ServiceException(ExceptionConstant.SERVICE_EXCEPTION);
        }
        return response;
    }

    @Override
    public UpdateCarResponse updateCar(BaseRequest requestHeader, UpdateCarRequest request) throws Exception {
        Date currentDate = new Date();
        UpdateCarResponse response = new UpdateCarResponse();
        try {
            Car updateCar = carDao.findById(request.getCarID());
            if (updateCar==null) {
                throw new ServiceException(ExceptionConstant.NOT_FOUND_EXCEPTION);
            }
            String beforeUpdate = updateCar.toString();
            updateCar.setBrand(request.getBrand());
            updateCar.setName(request.getName());
            updateCar.setDriveSystem(request.getDriveSystem());
            updateCar.setGearType(request.getGearType());
            updateCar.setEngine(request.getEngine());
            updateCar.setCarType(request.getCarType());
            updateCar.setOilType(request.getOilType());
            if (StringUtils.isNotEmtyOrNull(request.getYear())) {
                updateCar.setYear(Integer.parseInt(request.getYear()));
            }
            if (StringUtils.isNotEmtyOrNull(request.getPrice())) {
                updateCar.setPrice(Integer.parseInt(request.getPrice()));
            }
            carDao.update(request.getCarID(),updateCar);
            logActionService.updateCarLog(request.getCarID(),beforeUpdate,updateCar.toString());
            response.setStatus(CommonConstant.RESPONSE_SUCCESS);
            response.setStatusCode(CommonConstant.RESPONSE_CODE_SUCCESS);
            response.setTimestamp(DateUtils.formatDateToString(currentDate,DateTimeConstant.APPLICATION_DATE_FORMAT));
            response.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (ServiceException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ServiceException(ExceptionConstant.SERVICE_EXCEPTION);
        }
        return response;
    }

    @Override
    public DeleteCarResponse deleteCar(BaseRequest requestHeader, DeleteCarRequest request) throws Exception {
        Date currentDate = new Date();
        DeleteCarResponse response = new DeleteCarResponse();
        try {
            Car deleteCar = carDao.findById(request.getCarID());
            if (deleteCar==null) {
                throw new ServiceException(ExceptionConstant.NOT_FOUND_EXCEPTION);
            }
            deleteCar.setIsDelete(CommonConstant.FLAG_YES);
            carDao.update(request.getCarID(),deleteCar);
            logActionService.deleteCarLog(request.getCarID());
            response.setStatus(CommonConstant.RESPONSE_SUCCESS);
            response.setStatusCode(CommonConstant.RESPONSE_CODE_SUCCESS);
            response.setTimestamp(DateUtils.formatDateToString(currentDate,DateTimeConstant.APPLICATION_DATE_FORMAT));
            response.setMessage(CommonConstant.RESPONSE_MESSAGE_SUCCESS);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (ServiceException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ServiceException(ExceptionConstant.SERVICE_EXCEPTION);
        }
        return response;
    }
}
