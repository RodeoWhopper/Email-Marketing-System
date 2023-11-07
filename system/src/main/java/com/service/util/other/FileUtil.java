package com.service.util.other;

import com.service.util.enums.Topic;
import com.service.util.exceptions.file.ReadHtmlFileException;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtil {



    public static String[] getContentByTopic(Topic topic) throws RuntimeException{
        String[] values;
        switch (topic){
            case FIVE_DAYS -> {
                values = FileUtil.readHTMLFile("resources/mail-patterns/5Days.html");
                return values;
            }
            case THIRTY_DAYS -> {
                values = FileUtil.readHTMLFile("resources/mail-patterns/30Days.html");
                return values;
            }
            default -> {
                throw new RuntimeException();
            }
        }
    }

    private static String[] readHTMLFile(String path) throws RuntimeException{
        try{

            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = null, subject = null, htmlContent = null;

            while((line = reader.readLine()) != null){
                if(line.contains("<subject>")){
                    subject = line;
                    subject.substring(9,subject.length() - 10).trim();
                }
                stringBuilder.append(line);
            }
            htmlContent = stringBuilder.toString();

            String[] values = {htmlContent,subject};
            return values;

        } catch(Exception e){

            throw new ReadHtmlFileException();
            
        }
    }

}
