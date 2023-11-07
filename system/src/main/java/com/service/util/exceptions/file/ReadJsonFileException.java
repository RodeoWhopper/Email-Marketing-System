package com.service.util.exceptions.file;

public class ReadJsonFileException extends RuntimeException{
    public ReadJsonFileException() {
        super("Something went wrong on reading file from a JSON file");
    }

    public ReadJsonFileException(String message) {
        super(message);
    }
}
