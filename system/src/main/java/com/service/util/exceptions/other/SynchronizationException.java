package com.service.util.exceptions.other;

public class SynchronizationException extends RuntimeException{
    public SynchronizationException() {
        super("Something went wrong in synchronization");
    }

    public SynchronizationException(String message) {
        super(message);
    }
}
