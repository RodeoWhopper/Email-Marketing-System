package com.service.util;

import com.service.util.exceptions.file.ReadFileException;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtil {
    public static String readHTMLFile(String path) throws RuntimeException{
        try{

            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;

            while((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }

            return stringBuilder.toString();

        } catch(Exception e){

            throw new ReadFileException();
            
        }
    }
}
