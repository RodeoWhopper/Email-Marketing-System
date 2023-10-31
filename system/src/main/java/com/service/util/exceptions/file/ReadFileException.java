package com.service.util.exceptions.file;

public class ReadFileException extends RuntimeException{
    public ReadFileException() {
        super("Something went wrong on reading file from a HTML page");
    }

    public ReadFileException(String message) {
        super(message);
    }
}
