package com.service.api.dao;

import com.service.api.domain.LogAction;

import java.util.List;

public interface LogActionDao {
    public void insert(List<LogAction> insertObjectList) throws Exception;
}
