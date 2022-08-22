package com.service.api.util;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Util class");
    }
    public static boolean isNotEmtyOrNull(String input){
        return !(input == null || "".equals(input.trim()) || input.trim().length() == 0 || input.equalsIgnoreCase("null"));
    }
}
