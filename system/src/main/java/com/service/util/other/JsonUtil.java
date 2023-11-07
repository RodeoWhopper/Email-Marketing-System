package com.service.util.other;

import com.google.common.collect.Lists;
import com.service.util.exceptions.file.ReadJsonFileException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JsonUtil {

    public static String[] getSmtpAddress(){
        try{
            JsonObject object = readObject();
            String address = object.getJsonObject("smtp").getString("address");
            String port = object.getJsonObject("smtp").getString("port");
            String[] values = {address,port};
            return values;
        } catch (Exception e){
            throw new ReadJsonFileException();
        }
    }
    
    public static String[] getEmailAccount(){
        try{
            JsonObject object = readObject(), emailAccount = object.getJsonObject("email-account");
            String username = emailAccount.getString("username"),
                    password = emailAccount.getString("password");
            String[] values = {username,password};
            return values;
        } catch (Exception e){
            throw new ReadJsonFileException();
        }
    }

    private static JsonObject readObject() throws RuntimeException{
        String environmentPath = "src/main/java/com/service/util/environment/environment.json";
        try{
            JsonReader jsonReader = Json.createReader(new FileReader(environmentPath));
            JsonObject jsonObject = jsonReader.readObject();
            return jsonObject;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
