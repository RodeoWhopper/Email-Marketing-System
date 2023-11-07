package com.service.util.exceptions.mail.base;

public class MailBuilderException extends RuntimeException{
    public MailBuilderException() {
        super("There is something wrong with mail builder");
    }

    public MailBuilderException(String message) {
        super(message);
    }
}
