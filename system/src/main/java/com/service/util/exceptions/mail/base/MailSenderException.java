package com.service.util.exceptions.mail.base;

public class MailSenderException extends RuntimeException{
    public MailSenderException() {
        super("Something went wrong on sending email");
    }

    public MailSenderException(String message) {
        super(message);
    }
}
