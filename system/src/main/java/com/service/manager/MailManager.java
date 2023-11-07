package com.service.manager;

import com.service.model.Mail;
import com.service.util.exceptions.mail.base.MailSenderException;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailManager {


    public void sendMail(Mail mail) throws MailSenderException{
        String receiver = mail.getReceiverAddress(),
                sender = mail.getSenderAddress(),
                senderPassword = mail.getSenderAddressPassword(),
                smtpServer =  mail.getSmtpServerAddress(),
                smtpPort = mail.getSmtpServerPort(),
                mailContent = mail.getMailContent(),
                mailSubject = mail.getMailSubject();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host",smtpServer);
        properties.put("mail.smtp.port",smtpPort);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender,senderPassword);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));
            message.setSubject(mailSubject);
            message.setText(mailContent);

            Transport.send(message);

            System.out.println("Mail başarıyla gönderildi");
        }catch (Exception e){
            throw new MailSenderException();
        }

    }

}
