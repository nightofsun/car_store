package com.service.api.service;

import java.util.Date;

public interface LoggerService {
    public void accessLogger(Date startDate, Date endDate, String path, Object input, Object output);
    public void systemLogger(String ref, String message, String value);
}
