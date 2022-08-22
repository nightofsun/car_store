package com.service.api.service;

import com.service.api.domain.Car;

import java.util.List;

public interface TestCar {

    List<Car> find() throws Exception;
}
