package com.service.api.service.impl;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.ExceptionConstant;
import com.service.api.dao.LogActionDao;
import com.service.api.domain.LogAction;
import com.service.api.exceptions.DatabaseException;
import com.service.api.service.LogActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LogActionServiceImpl implements LogActionService {
    @Autowired
    LogActionDao logActionDao;
    @Override
    public void createNewCarLog(String carID, String carAttribute) throws Exception {
        Date currentDate = new Date();
        try {
            List<LogAction> logActionList = new ArrayList<>();
            LogAction logAction = new LogAction();
            logAction.setId(UUID.randomUUID().toString());
            logAction.setCarId(carID);
            logAction.setActionType(CommonConstant.ACTION_TYPE_CREATE);
            logAction.setAfter(carAttribute);
            logAction.setCreateAt(currentDate);
            logAction.setIsDelete(CommonConstant.FLAG_NO);
            logActionList.add(logAction);
            logActionDao.insert(logActionList);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void updateCarLog(String carID, String carAttributeBefore, String carAttributeAfter) throws Exception {
        Date currentDate = new Date();
        try {
            List<LogAction> logActionList = new ArrayList<>();
            LogAction logAction = new LogAction();
            logAction.setId(UUID.randomUUID().toString());
            logAction.setCarId(carID);
            logAction.setActionType(CommonConstant.ACTION_TYPE_UPDATE);
            logAction.setBefore(carAttributeBefore);
            logAction.setAfter(carAttributeAfter);
            logAction.setCreateAt(currentDate);
            logAction.setIsDelete(CommonConstant.FLAG_NO);
            logActionList.add(logAction);
            logActionDao.insert(logActionList);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteCarLog(String carID) throws Exception {
        Date currentDate = new Date();
        try {
            List<LogAction> logActionList = new ArrayList<>();
            LogAction logAction = new LogAction();
            logAction.setId(UUID.randomUUID().toString());
            logAction.setCarId(carID);
            logAction.setActionType(CommonConstant.ACTION_TYPE_DELETE);
            logAction.setCreateAt(currentDate);
            logAction.setIsDelete(CommonConstant.FLAG_NO);
            logActionList.add(logAction);
            logActionDao.insert(logActionList);
        }
        catch (DataAccessException e) {
            throw new DatabaseException(ExceptionConstant.DATABASE_EXCEPTION);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
