package com.service.tasks;

import com.service.manager.MailManager;
import com.service.model.Mail;

public class SendMailTask implements Runnable{
    private Mail mail;
    private MailManager mailManager;

    public SendMailTask(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {

    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

}
