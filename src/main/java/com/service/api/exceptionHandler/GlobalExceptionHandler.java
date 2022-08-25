package com.service.api.exceptionHandler;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.DateTimeConstant;
import com.service.api.constant.ExceptionConstant;
import com.service.api.exceptions.DatabaseException;
import com.service.api.exceptions.ServiceException;
import com.service.api.exceptions.ServiceValidationException;
import com.service.api.model.rest.BaseRequest;
import com.service.api.model.rest.BaseResponse;
import com.service.api.service.LoggerService;
import com.service.api.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private LoggerService loggerService;
    private BaseResponse generateResponseMessage(Exception e, String message) {
        BaseResponse response = new BaseResponse();
        response.setMessage(message);
        response.setStatus(CommonConstant.RESPONSE_FAIL);
        response.setStatusCode(e.getMessage());
        response.setTimestamp(DateUtils.formatDateToString(new Date(), DateTimeConstant.APPLICATION_DATE_FORMAT));
        loggerService.systemLogger(CommonConstant.LOG_EXCEPTION,e.getMessage(),response.toString(),CommonConstant.LOG_LEVEL_WARNING);
        return response;
    }
    @ExceptionHandler(ServiceValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse handleServiceValidationException(ServiceValidationException e){
        return generateResponseMessage(e, ExceptionConstant.SERVICE_VALIDATION_EXCEPTION_MESSAGE);
    }
    @ExceptionHandler(DatabaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse handleDatabaseException(DatabaseException e){
        return generateResponseMessage(e,null);
    }
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse handleDataAccessException(DataAccessException e){
        return generateResponseMessage(e,null);
    }
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse handleServiceException(ServiceException e){
        return generateResponseMessage(e,ExceptionConstant.SERVICE_EXCEPTION_MESSAGE);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse handleException(Exception e){
        return generateResponseMessage(e,null);
    }
}
