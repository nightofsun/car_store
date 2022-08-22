package com.service.api.constant;

public class DatabaseConstant {
    private DatabaseConstant() {
        throw new IllegalStateException();
    }
    public static final String SELECT_STAR_FROM = " select * from ";
    public static final String SELECT_COUNT_FROM = " select count(*) from ";
    public static final String INSERT_INTO = " insert into ";
    public static final String UPDATE = " update ";
    public static final String WHERE = " WHERE ";
    public static final String SET = " SET ";
    public static final String AND = " and ";
    public static final String EQUAL_QUESTION_MARK = " = ? ";
    public static final String OVER_EQUAL_QUESTION_MARK = " >= ? ";
    public static final String LESS_EQUAL_QUESTION_MARK = " <= ? ";
    public static final String SIGN_QESTION_MARK = " ? ";
    public static final String SIGN_COMMA = ",";
    public static final String SIGN_PERCENT = "%";
    public static final String LIKE_QUESTION_MARK = " like ? ";
    public static final String LIMIT_QUESTION_MARK = "  limit ? ";
    public static final String WHERE_0_EQUAL_0 = " where 0 = 0 ";
    public static final String LOWER = " lower";
    public static final String OPEN_BRACKET = "( ";
    public static final String CLOSE_BRACKET = " )";

    public static final String ORDER_BY = " ORDER BY ";
    public static final String ASC = "  ASC ";
    public static final String DESC = "  DESC ";

}
