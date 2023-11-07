package com.service.tasks;

import com.service.manager.MailManager;
import com.service.model.Mail;

public class SendMailTask extends Thread {
    private Mail mail;
    private MailManager mailManager;

    public SendMailTask(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        mailManager.sendMail(getMail());

        //Logging

    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

}
