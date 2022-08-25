package com.service.api.dao.impl;

import com.service.api.constant.CommonConstant;
import com.service.api.constant.DatabaseConstant;
import com.service.api.dao.LogActionDao;
import com.service.api.domain.Car;
import com.service.api.domain.LogAction;
import com.service.api.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogActionDaoImpl implements LogActionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LoggerService loggerService;
    private final String TABLE = "log_action";
    private final String CREATE_AT = "create_at";
    private final String UPDATE_AT = "update_at";
    private final String IS_DELETE = "is_delete";

    private final String ID = "id";
    private final String CAR_ID = "car_id";
    private final String ACTION_TYPE = "action_type";
    private final String BEFORE = "before_action";
    private final String AFTER = "after_action";

    @Override
    public void insert(List<LogAction> insertObjectList) throws Exception {
        StringBuilder sql = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        try {
            //setup column
            sql.append(DatabaseConstant.INSERT_INTO).append(TABLE).append(DatabaseConstant.OPEN_BRACKET)
                    .append(CREATE_AT).append(DatabaseConstant.SIGN_COMMA)
                    .append(IS_DELETE).append(DatabaseConstant.SIGN_COMMA);
            sql
                    .append(ID).append(DatabaseConstant.SIGN_COMMA)
                    .append(CAR_ID).append(DatabaseConstant.SIGN_COMMA)
                    .append(ACTION_TYPE).append(DatabaseConstant.SIGN_COMMA)
                    .append(BEFORE).append(DatabaseConstant.SIGN_COMMA)
                    .append(AFTER)
                    .append(DatabaseConstant.CLOSE_BRACKET);
            if (insertObjectList!=null && insertObjectList.size()>0) {
                int size = insertObjectList.size();
                sql.append(" values ");
                for (int i = 0; i < size ; i++) {
                    LogAction insertObj = insertObjectList.get(i);

                    //setup prepareStatement
                    sql.append(DatabaseConstant.OPEN_BRACKET)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK)
                            .append(DatabaseConstant.CLOSE_BRACKET);
                    if (i < size - 1) {
                        sql.append(DatabaseConstant.SIGN_COMMA);
                    }

                    //setup object statement

                    parameters.add(insertObj.getCreateAt());
                    parameters.add(insertObj.getIsDelete());
                    parameters.add(insertObj.getId());
                    parameters.add(insertObj.getCarId());
                    parameters.add(insertObj.getActionType());
                    parameters.add(insertObj.getBefore());
                    parameters.add(insertObj.getAfter());
                }
            }
            loggerService.systemLogger(TABLE, CommonConstant.LOG_QUERY,sql.toString(),CommonConstant.LOG_LEVEL_INFO);
            loggerService.systemLogger(TABLE,CommonConstant.LOG_PARAMETER,parameters.toString(),CommonConstant.LOG_LEVEL_INFO);
            jdbcTemplate.update(sql.toString(), parameters.toArray());
        }
        catch (DataAccessException e) {
            throw e;
        }
        catch (Exception e) {
            throw e;
        }

    }
}
