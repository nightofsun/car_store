package com.service.api.service.impl;


import com.service.api.dao.CarDao;
import com.service.api.domain.Car;
import com.service.api.service.TestCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestCar {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> find() throws Exception {
        Car car = new Car();
        car.setName("hon");
        return carDao.find(car, 200, 100900000, 2,1);
    }
}
