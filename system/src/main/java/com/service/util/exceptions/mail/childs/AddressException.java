package com.service.util.exceptions.mail.childs;

import com.service.util.exceptions.mail.base.MailBuilderException;

public class AddressException extends MailBuilderException {
    public AddressException() {
        super("Receiver or sender address is wrong");
    }

    public AddressException(String message) {
        super(message);
    }
}
