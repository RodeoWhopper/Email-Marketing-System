package com.service.util.builders.conc;

import com.service.model.Mail;
import com.service.util.MailUtil;
import com.service.util.builders.Builder;
import com.service.util.exceptions.mail.MailBuilderException;
import com.service.util.exceptions.mail.childs.AddressException;
import com.service.util.exceptions.mail.childs.MailContentException;

public class MailBuilder implements Builder<Mail> {
    @Override
    public Mail build(String... args) throws RuntimeException {
        if(args.length < 5){
            if(MailUtil.isMailValid(args[0]) && MailUtil.isMailValid(args[1])){
                String receiverAddress = args[0], senderAddress = args[1];
                String smtpServerAddress = args[2];

                if(MailUtil.isAnIp(smtpServerAddress)){
                    String smtpServerPort = args[3];
                    if(MailUtil.isContentValid(args[4])){
                        String mailContent = args[4];
                        String mailSubject = args[5];
                        return new Mail(receiverAddress,senderAddress,smtpServerAddress,smtpServerPort,mailContent,mailSubject);
                    } else {
                        throw new MailContentException();
                    }
                } else {
                    if(MailUtil.isContentValid(args[3])){
                        String mailContent = args[3];
                        String mailSubject = args[4];
                        return new Mail(receiverAddress,senderAddress,smtpServerAddress,mailContent,mailSubject);
                    } else {
                        throw new MailContentException();
                    }
                }
            } else {
                throw new AddressException();
            }
        } else {
            throw new MailBuilderException();
        }
    }
}
