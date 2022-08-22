package com.service.api.service.impl;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.ExceptionConstant;
import com.service.api.dao.CarDao;
import com.service.api.domain.Car;
import com.service.api.exceptions.DatabaseException;
import com.service.api.model.rest.BaseRequest;
import com.service.api.model.rest.request.CreateNewCarRequest;
import com.service.api.model.rest.request.DeleteCarRequest;
import com.service.api.model.rest.request.GetCarListRequest;
import com.service.api.model.rest.request.UpdateCarRequest;
import com.service.api.model.rest.response.*;
import com.service.api.service.CarService;
import com.service.api.service.LogActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;
    @Autowired
    LogActionService logActionService;
    @Override
    public GetCarListResponse getCarList(BaseRequest requestHeader, GetCarListRequest request) throws Exception {
        GetCarListResponse response = new GetCarListResponse();
        Date currentDate = new Date();
        List<CarAttribute> carAttributeList = new ArrayList<>();
        try {
            Car car = new Car();
            car.setName(request.getName());
            car.setGearType(request.getGearType());
            car.setCarType(request.getCarType());
            car.setBrand(request.getBrand());
            car.setIsDelete(CommonConstant.FLAG_NO);
            int count = carDao.getCount(car, request.getMinPrice(), request.getMaxPrice(), request.getSortType(), request.getPage());
            List<Car> carList = carDao.find(car, request.getMinPrice(), request.getMaxPrice(), request.getSortType(), request.getPage());
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
            response.setCarList(carAttributeList);
            response.setCarCount(count);
            response.setStartAt((request.getPage()-1)*CommonConstant.PAGE_SIZE);
            response.setEndAt((request.getPage()*CommonConstant.PAGE_SIZE<count)?request.getPage()*CommonConstant.PAGE_SIZE: count);
            response.setTotalPage((int) Math.ceil(count/(CommonConstant.PAGE_SIZE*1.0)));
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw e;
        }
        return response;
    }

    @Override
    public CreateNewCarResponse createNewCar(BaseRequest requestHeader, CreateNewCarRequest request) throws Exception {
        return null;
    }

    @Override
    public UpdateCarResponse updateCar(BaseRequest requestHeader, UpdateCarRequest request) throws Exception {
        return null;
    }

    @Override
    public DeleteCarResponse deleteCar(BaseRequest requestHeader, DeleteCarRequest request) throws Exception {
        return null;
    }
}
