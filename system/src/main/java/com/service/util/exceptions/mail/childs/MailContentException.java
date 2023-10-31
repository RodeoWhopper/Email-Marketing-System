package com.service.util.exceptions.mail.childs;

public class MailContentException extends RuntimeException{
    public MailContentException() {
        super("The specified mail content is invalid for sending");
    }

    public MailContentException(String message) {
        super(message);
    }
}
