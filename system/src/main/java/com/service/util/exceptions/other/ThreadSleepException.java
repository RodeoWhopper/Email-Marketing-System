package com.service.util.exceptions.other;

public class ThreadSleepException extends RuntimeException{
    public ThreadSleepException() {
        super("Something went wrong when thread is sleeping");
    }

    public ThreadSleepException(String message) {
        super(message);
    }
}
