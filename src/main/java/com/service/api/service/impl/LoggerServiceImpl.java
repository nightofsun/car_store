package com.service.api.service.impl;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.DateTimeConstant;
import com.service.api.service.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DateTimeConstant.APPLICATION_DATE_FORMAT);
    private final Logger accessLogger = LoggerFactory.getLogger(CommonConstant.ACCESS_LOG);
    private final Logger systemLogger = LoggerFactory.getLogger(CommonConstant.SYSTEM_LOG);
    @Override
    public void accessLogger(Date startDate, Date endDate, String path, Object input, Object output) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("StartDate=[")
                .append(dateFormat.format(startDate))
                .append("], EndDate=[")
                .append(dateFormat.format(endDate))
                .append("], Path=[")
                .append(path)
                .append("], Input=[")
                .append(input == null ? "": input.toString())
                .append("], Output=[")
                .append(output == null ? "": output.toString())
                .append("]");
        accessLogger.info(sb.toString());
    }

    @Override
    public void systemLogger(String ref, String message, String value, String level) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Ref=[")
                .append(ref)
                .append("], Message=[")
                .append(message)
                .append("], Value=[")
                .append(value)
                .append("]");
        String log = sb.toString();
        if (level == CommonConstant.LOG_LEVEL_INFO){
            systemLogger.info(log);
        }
        else if (level == CommonConstant.LOG_LEVEL_WARNING){
            systemLogger.warn(log);
        }
        else {
            systemLogger.trace(log);
        }
    }
}
