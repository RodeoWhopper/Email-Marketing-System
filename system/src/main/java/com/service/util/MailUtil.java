package com.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailUtil {
    public static boolean isMailValid(String str){
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return stringValidator(emailPattern,str);
    }
    public static boolean isAnIp(String str) {
        String ipPattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return stringValidator(ipPattern,str);
    }

    private static boolean stringValidator(String pattern,String target){
        Pattern temp = Pattern.compile(pattern);
        Matcher matcher = temp.matcher(target);
        return matcher.matches();
    }
}
