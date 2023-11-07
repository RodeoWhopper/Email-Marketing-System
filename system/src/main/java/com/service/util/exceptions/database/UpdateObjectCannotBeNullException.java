package com.service.util.exceptions.database;

public class UpdateObjectCannotBeNullException extends RuntimeException{
    public UpdateObjectCannotBeNullException() {
        super("The object wanted to be updated is cannot be null");
    }

    public UpdateObjectCannotBeNullException(String message) {
        super(message);
    }
}
