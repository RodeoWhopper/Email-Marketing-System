package com.service.util.exceptions.file;

public class InvalidTopicException extends RuntimeException{
    public InvalidTopicException() {
        super("The topic is invalid in builder and cannot read the HTML file");
    }

    public InvalidTopicException(String message) {
        super(message);
    }
}
