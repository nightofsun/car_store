package com.service.api.dao;

import com.service.api.domain.Car;

import java.util.List;

public interface CarDao {
    public List<Car> find(Car findObject, Integer minPrice, Integer maxPrice, Integer sortType, Integer page) throws Exception;
    public void insert(List<Car> insertObjectList) throws Exception;
    public void update(String refID, Car updateObject) throws Exception;
    public Integer getCount(Car findObject, Integer minPrice, Integer maxPrice, Integer sortType, Integer page) throws Exception;

}
