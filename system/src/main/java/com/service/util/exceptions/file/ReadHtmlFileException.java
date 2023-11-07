package com.service.util.exceptions.file;

public class ReadHtmlFileException extends RuntimeException{
    public ReadHtmlFileException() {
        super("Something went wrong on reading file from a HTML page");
    }

    public ReadHtmlFileException(String message) {
        super(message);
    }
}
