package com.service.api.dao;

import com.service.api.domain.Car;

import java.util.List;

public interface CarDao {
    public Car findById(String carId) throws Exception;
    public List<Car> find(Car findObject, String minPrice, String maxPrice, String sortType, Integer page) throws Exception;
    public void insert(List<Car> insertObjectList) throws Exception;
    public void update(String refID, Car updateObject) throws Exception;
    public Integer getCount(Car findObject, String minPrice, String maxPrice) throws Exception;

}
