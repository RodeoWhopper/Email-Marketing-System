package com.service.util.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailUtil {
    public static boolean isMailValid(String str){
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return stringValidator(emailRegex,str);
    }
    public static boolean isAnIp(String str) {
        String ipPattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return stringValidator(ipPattern,str);
    }
    public static boolean isContentValid(String fileContent){
        return fileContent.contains("<!DOCTYPE html>");
    }

    private static boolean stringValidator(String pattern,String target){
        Pattern temp = Pattern.compile(pattern);
        Matcher matcher = temp.matcher(target);
        return matcher.matches();
    }
}
