package com.service.api.util;

import com.google.gson.Gson;

public class JSONUtils {
    private JSONUtils() {
        throw new IllegalStateException("Util class");
    }
    public static Object transfromStringToObject(String jsonString, Class<?> clas) {
        if(StringUtils.isNotEmtyOrNull(jsonString)){
            Gson gson = new Gson();
            return gson.fromJson(jsonString,clas);
        }
        return null;
    }
}
