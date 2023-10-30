package com.service.util.builders.conc;

import com.service.model.Mail;
import com.service.util.MailUtil;
import com.service.util.builders.Builder;
import com.service.util.exceptions.mail.MailBuilderException;
import com.service.util.exceptions.mail.childs.AddressException;

public class MailBuilder implements Builder<Mail> {
    @Override
    public Mail build(String... args) throws MailBuilderException {
        if(args.length > 0){
            if(MailUtil.isMailValid(args[0]) && MailUtil.isMailValid(args[1])){
                String receiverAddress = args[0], senderAddress = args[1];
                String smtpServerAddress = args[2];

                if(MailUtil.isAnIp(smtpServerAddress)){
                    String smtpServerPort = args[3];
                }


            } else {
                throw new AddressException();
            }
        } else {
            throw new MailBuilderException();
        }
        return null;
    }
}
