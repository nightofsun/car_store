package com.service.api.controller;

import com.service.api.dao.CarDao;
import com.service.api.domain.Car;
import com.service.api.service.LogActionService;
import com.service.api.service.TestCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Test {
    @Autowired
    private TestCar testCar;
    @Autowired
    private CarDao carDao;
    @Autowired
    LogActionService logActionService;
    @GetMapping("/car")
    @ResponseBody
    public List<Car> getCar() throws Exception {
        System.out.println("Test");
        Car car = new Car();
        logActionService.createNewCarLog("12342","Test01");
        logActionService.updateCarLog("1234","Before","After");
        logActionService.deleteCarLog("1234");
        return testCar.find();
    }
    @GetMapping("/testCar")
    public Integer getCar2() throws Exception {
        System.out.println("Test");
        Car car = new Car();
        return carDao.getCount(car,100,1000000,1,1);
    }
}
