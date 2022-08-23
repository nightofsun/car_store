package com.service.api.controller;

import com.service.api.constant.ExceptionConstant;
import com.service.api.exceptions.ServiceValidationException;
import com.service.api.model.rest.request.CreateNewCarRequest;
import com.service.api.model.rest.request.DeleteCarRequest;
import com.service.api.model.rest.request.GetCarListRequest;
import com.service.api.model.rest.request.UpdateCarRequest;
import com.service.api.util.ObjectValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CarControllerValidator {
    @Autowired
    private ObjectValidatorUtils validatorUtils;
    protected void getCarListValidation(GetCarListRequest request) throws ServiceValidationException {
        if (!validatorUtils.validateMandatory(request.getPage())) {
            throw new ServiceValidationException(ExceptionConstant.PAGE_NUMBER_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getSortType())) {
            throw new ServiceValidationException(ExceptionConstant.SORT_TYPE_MISSING);
        }
        if (!validatorUtils.validateInteger(request.getPage())) {
            throw new ServiceValidationException(ExceptionConstant.PAGE_NUMBER_INVALID_TYPE);
        }
        if (!validatorUtils.validateInteger(request.getSortType())) {
            throw new ServiceValidationException(ExceptionConstant.SORT_TYPE_INVALID_TYPE);
        }
        if (!validatorUtils.validateInteger(request.getMinPrice())) {
            throw new ServiceValidationException(ExceptionConstant.MIN_PRICE_INVALID_TYPE);
        }
        if (!validatorUtils.validateInteger(request.getMaxPrice())) {
            throw new ServiceValidationException(ExceptionConstant.MAX_PRICE_INVALID_TYPE);
        }
    }
    protected void createNewCarValidation(CreateNewCarRequest request) throws ServiceValidationException {
        if (!validatorUtils.validateMandatory(request.getBrand())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_BRAND_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getName())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_NAME_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getGearType())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_GEAR_TYPE_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getYear())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_YEAR_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getPrice())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_PRICE_MISSING);
        }
        if (!validatorUtils.validateInteger(request.getYear())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_YEAR_INVALID);
        }
        if (!validatorUtils.validateInteger(request.getPrice())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_PRICE_INVALID);
        }
        if (!validatorUtils.validateLength(request.getBrand(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_BRAND_INVALID);
        }
        if (!validatorUtils.validateLength(request.getGearType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_CAR_TYPE_INVALID);
        }
        if (!validatorUtils.validateLength(request.getCarType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_CAR_TYPE_INVALID);
        }
        if (!validatorUtils.validateLength(request.getOilType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_OIL_TYPE_INVALID);
        }
    }
    protected void updateCarValidation(UpdateCarRequest request) throws ServiceValidationException {
        if (!validatorUtils.validateMandatory(request.getCarID())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_ID_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getBrand())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_BRAND_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getName())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_NAME_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getGearType())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_GEAR_TYPE_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getYear())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_YEAR_MISSING);
        }
        if (!validatorUtils.validateMandatory(request.getPrice())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_PRICE_MISSING);
        }
        if (!validatorUtils.validateInteger(request.getYear())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_YEAR_INVALID);
        }
        if (!validatorUtils.validateInteger(request.getPrice())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_PRICE_INVALID);
        }
        if (!validatorUtils.validateLengthEqual(request.getCarID(), 36)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_ID_INVALID);
        }
        if (!validatorUtils.validateLength(request.getBrand(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_BRAND_INVALID);
        }
        if (!validatorUtils.validateLength(request.getGearType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_CAR_TYPE_INVALID);
        }
        if (!validatorUtils.validateLength(request.getCarType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_CAR_TYPE_INVALID);
        }
        if (!validatorUtils.validateLength(request.getOilType(),50)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_OIL_TYPE_INVALID);
        }
    }
    protected void deleteCarValidation(DeleteCarRequest request) throws ServiceValidationException {
        if (!validatorUtils.validateMandatory(request.getCarID())) {
            throw new ServiceValidationException(ExceptionConstant.CAR_ID_MISSING);
        }
        if (!validatorUtils.validateLengthEqual(request.getCarID(), 36)) {
            throw new ServiceValidationException(ExceptionConstant.CAR_ID_INVALID);
        }
    }
}
