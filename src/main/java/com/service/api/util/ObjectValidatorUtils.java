package com.service.api.util;

import org.springframework.stereotype.Component;
import static com.service.api.util.StringUtils.isNotEmtyOrNull;
@Component
public class ObjectValidatorUtils {
    public static boolean validateMandatory(String str){
        return !(str==null || "".equals(str.trim()) || str.trim().length()==0 || str.equalsIgnoreCase("null"));
    }
    public static boolean validateLength(String str, int maxLength) {
        return (str!=null) && (str.length()<=maxLength);
    }
    public static boolean validateLengthEqual(String str, int length) {
        return (str!=null) && (str.length()==length);
    }
    public static boolean validateInteger(String str) {
        try {
            if (isNotEmtyOrNull(str)){
                Integer.parseInt(str);
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
