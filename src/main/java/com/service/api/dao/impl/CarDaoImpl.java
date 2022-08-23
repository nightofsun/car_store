package com.service.api.dao.impl;

import com.service.api.constant.DatabaseConstant;
import com.service.api.constant.CommonConstant;
import com.service.api.dao.CarDao;
import com.service.api.domain.Car;
import com.service.api.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String TABLE = "cars";
    private final String CREATE_AT = "create_at";
    private final String UPDATE_AT = "update_at";
    private final String IS_DELETE = "is_delete";

    private final String CAR_ID = "car_id";
    private final String BRAND = "brand";
    private final String NAME = "name";
    private final String DRIVE_SYSTEM = "drive_system";
    private final String GEAR_TYPE = "gear_type";
    private final String YEAR = "year";
    private final String ENGINE = "engine";
    private final String PRICE = "price";
    private final String CAR_TYPE = "car_type";
    private final String OIL_TYPE = "oil_type";
    private final String SORT_TYPE[] = {
            DatabaseConstant.ORDER_BY.concat(CREATE_AT).concat(DatabaseConstant.DESC),
            DatabaseConstant.ORDER_BY.concat(CREATE_AT).concat(DatabaseConstant.ASC),
            DatabaseConstant.ORDER_BY.concat(PRICE).concat(DatabaseConstant.DESC),
            DatabaseConstant.ORDER_BY.concat(PRICE).concat(DatabaseConstant.ASC)
    };
    final RowMapper<Car> ROW_MAPPER = (ResultSet rs, int i) ->{
        final Car mapperObject = new Car();
        mapperObject.setCreateAt(rs.getTimestamp(CREATE_AT));
        mapperObject.setUpdateAt(rs.getTimestamp(UPDATE_AT));
        mapperObject.setIsDelete(rs.getString(IS_DELETE));
        mapperObject.setCarID(rs.getString(CAR_ID));
        mapperObject.setBrand(rs.getString(BRAND));
        mapperObject.setName(rs.getString(NAME));
        mapperObject.setDriveSystem(rs.getString(DRIVE_SYSTEM));
        mapperObject.setGearType(rs.getString(GEAR_TYPE));
        mapperObject.setYear(rs.getInt(YEAR));
        mapperObject.setEngine(rs.getString(ENGINE));
        mapperObject.setPrice(rs.getInt(PRICE));
        mapperObject.setCarType(rs.getString(CAR_TYPE));
        mapperObject.setOilType(rs.getString(OIL_TYPE));
        return mapperObject;
    };

    @Override
    public Car findById(String carId) throws Exception {
        StringBuilder sql = new StringBuilder();
        List<Car> result = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        try {
            sql.append(DatabaseConstant.SELECT_STAR_FROM).append(TABLE);
            sql.append(DatabaseConstant.WHERE_0_EQUAL_0);
            sql
                    .append(DatabaseConstant.AND)
                    .append(IS_DELETE)
                    .append(DatabaseConstant.EQUAL_QUESTION_MARK);
            parameters.add(CommonConstant.FLAG_NO);
            if (StringUtils.isNotEmtyOrNull(carId)){
                sql
                        .append(DatabaseConstant.AND)
                        .append(CAR_ID)
                        .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                parameters.add(carId);
            }
            else {
                return null;
            }
            result = jdbcTemplate.query(sql.toString(),parameters.toArray(),ROW_MAPPER);
            if (result!=null && result.size()>0){
                return result.get(0);
            }
        }
        catch (DataAccessException e){
            throw e;
        }
        catch (Exception e){
            throw e;
        }
        return null;
    }

    @Override
    public List<Car> find(Car findObject, String minPrice, String maxPrice, String sortType, Integer page) throws Exception {
        StringBuilder sql = new StringBuilder();
        List<Car> resultList = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        try {
            sql.append(DatabaseConstant.SELECT_STAR_FROM).append(TABLE);
            sql.append(DatabaseConstant.WHERE_0_EQUAL_0);
            if(findObject!=null) {
                if(findObject.getCreateAt()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CREATE_AT)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCreateAt());
                }
                if(findObject.getUpdateAt()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(UPDATE_AT)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getUpdateAt());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getIsDelete())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(IS_DELETE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getIsDelete());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getCarID())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CAR_ID)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCarID());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getBrand())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(BRAND)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getBrand());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getName())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(DatabaseConstant.LOWER)
                            .append(DatabaseConstant.OPEN_BRACKET)
                            .append(NAME)
                            .append(DatabaseConstant.CLOSE_BRACKET)
                            .append(DatabaseConstant.LIKE_QUESTION_MARK);
                    parameters.add(DatabaseConstant.SIGN_PERCENT.concat(findObject.getName()).concat(DatabaseConstant.SIGN_PERCENT));
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getDriveSystem())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(DRIVE_SYSTEM)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getDriveSystem());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getGearType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(GEAR_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getGearType());
                }
                if(findObject.getYear()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(YEAR)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getYear());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getEngine())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(ENGINE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getEngine());
                }
                if(findObject.getPrice()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(PRICE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getPrice());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getCarType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CAR_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCarType());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getOilType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(OIL_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getOilType());
                }
            }
            if (StringUtils.isNotEmtyOrNull(minPrice)){
                sql
                        .append(DatabaseConstant.AND)
                        .append(PRICE)
                        .append(DatabaseConstant.OVER_EQUAL_QUESTION_MARK);
                parameters.add(minPrice);
            }
            if (StringUtils.isNotEmtyOrNull(maxPrice)){
                sql
                        .append(DatabaseConstant.AND)
                        .append(PRICE)
                        .append(DatabaseConstant.LESS_EQUAL_QUESTION_MARK);
                parameters.add(maxPrice);
            }
            if (StringUtils.isNotEmtyOrNull(sortType)&&Integer.parseInt(sortType)<SORT_TYPE.length) {
                sql
                        .append(SORT_TYPE[Integer.parseInt(sortType)]);
            }
            if (page!=null&&page>0){
                sql
                        .append(DatabaseConstant.LIMIT_QUESTION_MARK)
                        .append(DatabaseConstant.SIGN_COMMA)
                        .append(DatabaseConstant.SIGN_QESTION_MARK);
                parameters.add((page-1)* CommonConstant.PAGE_SIZE);
                parameters.add(page* CommonConstant.PAGE_SIZE);
            }
            resultList = jdbcTemplate.query(sql.toString(), parameters.toArray(), ROW_MAPPER);
        }
        catch (DataAccessException e){
            throw e;
        }
        catch (Exception e){
            throw e;
        }
        return resultList;
    }

    @Override
    public void insert(List<Car> insertObjectList) throws Exception {
        StringBuilder sql = new StringBuilder();
        List<Object> parameter = new ArrayList<>();
        try {
            //setup column
            sql
                    .append(DatabaseConstant.INSERT_INTO).append(TABLE).append(DatabaseConstant.OPEN_BRACKET)
                    .append(CREATE_AT).append(DatabaseConstant.SIGN_COMMA)
                    .append(IS_DELETE).append(DatabaseConstant.SIGN_COMMA);
            sql
                    .append(CAR_ID).append(DatabaseConstant.SIGN_COMMA)
                    .append(BRAND).append(DatabaseConstant.SIGN_COMMA)
                    .append(NAME).append(DatabaseConstant.SIGN_COMMA)
                    .append(DRIVE_SYSTEM).append(DatabaseConstant.SIGN_COMMA)
                    .append(GEAR_TYPE).append(DatabaseConstant.SIGN_COMMA)
                    .append(YEAR).append(DatabaseConstant.SIGN_COMMA)
                    .append(ENGINE).append(DatabaseConstant.SIGN_COMMA)
                    .append(PRICE).append(DatabaseConstant.SIGN_COMMA)
                    .append(CAR_TYPE).append(DatabaseConstant.SIGN_COMMA)
                    .append(OIL_TYPE)
                    .append(DatabaseConstant.CLOSE_BRACKET);
            if (insertObjectList!=null && insertObjectList.size()>0) {
                int size = insertObjectList.size();
                sql.append(" values ");
                for (int i = 0; i < size ; i++) {
                    Car insertObj = insertObjectList.get(i);

                    //setup prepareStatement
                    sql.append(DatabaseConstant.OPEN_BRACKET)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                            .append(DatabaseConstant.SIGN_QESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
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
                    parameter.add(insertObj.getCreateAt());
                    parameter.add(insertObj.getIsDelete());
                    parameter.add(insertObj.getCarID());
                    parameter.add(insertObj.getBrand());
                    parameter.add(insertObj.getName());
                    parameter.add(insertObj.getDriveSystem());
                    parameter.add(insertObj.getGearType());
                    parameter.add(insertObj.getYear());
                    parameter.add(insertObj.getEngine());
                    parameter.add(insertObj.getPrice());
                    parameter.add(insertObj.getCarType());
                    parameter.add(insertObj.getOilType());
                }
            }
            jdbcTemplate.update(sql.toString(), parameter.toArray());
        }
        catch (DataAccessException e) {
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(String refID, Car updateObject) throws Exception {
        StringBuilder sql = new StringBuilder();
        List<Object> parameter = new ArrayList<>();
        try {
            sql.append(DatabaseConstant.UPDATE).append(TABLE).append(DatabaseConstant.SET);
            if (updateObject!=null){
                //update column
                sql
                        .append(UPDATE_AT).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(IS_DELETE).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA);
                sql
                        .append(BRAND).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(NAME).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(DRIVE_SYSTEM).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(GEAR_TYPE).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(YEAR).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(ENGINE).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(PRICE).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(CAR_TYPE).append(DatabaseConstant.EQUAL_QUESTION_MARK).append(DatabaseConstant.SIGN_COMMA)
                        .append(OIL_TYPE).append(DatabaseConstant.EQUAL_QUESTION_MARK);
                //update condition
                sql
                        .append(DatabaseConstant.WHERE).append(CAR_ID).append(DatabaseConstant.EQUAL_QUESTION_MARK);
                //update column value
                parameter.add(updateObject.getUpdateAt());
                parameter.add(updateObject.getIsDelete());
                parameter.add(updateObject.getBrand());
                parameter.add(updateObject.getName());
                parameter.add(updateObject.getDriveSystem());
                parameter.add(updateObject.getGearType());
                parameter.add(updateObject.getYear());
                parameter.add(updateObject.getEngine());
                parameter.add(updateObject.getPrice());
                parameter.add(updateObject.getCarType());
                parameter.add(updateObject.getOilType());
                //update condition value
                parameter.add(updateObject.getCarID());
            }
            jdbcTemplate.update(sql.toString(), parameter.toArray());
        }
        catch (DataAccessException e) {
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer getCount(Car findObject, String minPrice, String maxPrice) throws Exception {
        StringBuilder sql = new StringBuilder();
        Integer result = null;
        List<Object> parameters = new ArrayList<>();
        try {
            sql.append(DatabaseConstant.SELECT_COUNT_FROM).append(TABLE);
            sql.append(DatabaseConstant.WHERE_0_EQUAL_0);
            if(findObject!=null) {
                if(findObject.getCreateAt()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CREATE_AT)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCreateAt());
                }
                if(findObject.getUpdateAt()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(UPDATE_AT)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getUpdateAt());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getIsDelete())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(IS_DELETE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getIsDelete());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getCarID())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CAR_ID)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCarID());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getBrand())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(BRAND)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getBrand());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getName())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(DatabaseConstant.LOWER)
                            .append(DatabaseConstant.OPEN_BRACKET)
                            .append(NAME)
                            .append(DatabaseConstant.CLOSE_BRACKET)
                            .append(DatabaseConstant.LIKE_QUESTION_MARK);
                    parameters.add(DatabaseConstant.SIGN_PERCENT.concat(findObject.getName()).concat(DatabaseConstant.SIGN_PERCENT));
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getDriveSystem())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(DRIVE_SYSTEM)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getDriveSystem());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getGearType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(GEAR_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getGearType());
                }
                if(findObject.getYear()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(YEAR)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getYear());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getEngine())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(ENGINE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getEngine());
                }
                if(findObject.getPrice()!=null){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(PRICE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getPrice());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getCarType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(CAR_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getCarType());
                }
                if(StringUtils.isNotEmtyOrNull(findObject.getOilType())){
                    sql
                            .append(DatabaseConstant.AND)
                            .append(OIL_TYPE)
                            .append(DatabaseConstant.EQUAL_QUESTION_MARK);
                    parameters.add(findObject.getOilType());
                }
            }
            if (StringUtils.isNotEmtyOrNull(minPrice)){
                sql
                        .append(DatabaseConstant.AND)
                        .append(PRICE)
                        .append(DatabaseConstant.OVER_EQUAL_QUESTION_MARK);
                parameters.add(minPrice);
            }
            if (StringUtils.isNotEmtyOrNull(maxPrice)){
                sql
                        .append(DatabaseConstant.AND)
                        .append(PRICE)
                        .append(DatabaseConstant.LESS_EQUAL_QUESTION_MARK);
                parameters.add(maxPrice);
            }
            result = jdbcTemplate.queryForObject(sql.toString(),parameters.toArray(), Integer.class);
        }
        catch (DataAccessException e){
            throw e;
        }
        catch (Exception e){
            throw e;
        }
        return result;
    }
}
