package com.service.util.exceptions.database;

public class DatabaseObjectCannotBeNullException extends RuntimeException{
    public DatabaseObjectCannotBeNullException() {
        super("The object wanted to be updated is cannot be null");
    }

    public DatabaseObjectCannotBeNullException(String message) {
        super(message);
    }
}
