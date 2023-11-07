package com.service.util.builders.conc;

import com.service.model.Mail;
import com.service.util.enums.Topic;
import com.service.util.exceptions.file.InvalidTopicException;
import com.service.util.other.MailUtil;
import com.service.util.builders.Builder;
import com.service.util.exceptions.mail.base.MailBuilderException;
import com.service.util.exceptions.mail.childs.AddressException;
import com.service.util.exceptions.mail.childs.MailContentException;

import static com.service.util.other.FileUtil.getContentByTopic;

public class MailBuilder implements Builder<Mail> {

    @Override
    public Mail build(String... args) throws RuntimeException {
        if(args.length == 7){
            //If arguments are not enough for build a mail, it throws MailBuilderException

            if(MailUtil.isMailValid(args[0]) && MailUtil.isMailValid(args[1])){

                //If receiver or sender email addresses doesn't fit into email regex, it throws AddressException

                String receiverAddress = args[0], senderAddress = args[1], senderPassword = args[2];
                String smtpServerAddress = args[3], smtpServerPort = args[4];

                //We are initializing our variable

                //These values are content and
                String[] values = new String[2];
                try{
                    //If string type value parameter it doesn't fit to any type of Topic enum, it throws InvalidTopicException

                    values = getContentByTopic(Topic.valueOf(args[5]));
                    //The sixth argument in this func is about topic of mail content
                    //With this func we are reading html pages

                } catch (Exception e){
                    throw new InvalidTopicException();
                }

                String mailContent = values[0], mailSubject = values[1];//If it passes, initializing


                if(MailUtil.isContentValid(mailContent)){

                    //If the content isn't in html format it throws MailContentException

                    return new Mail(receiverAddress,senderAddress,senderPassword,smtpServerAddress,smtpServerPort,mailContent,mailSubject);
                    //If it is return the Mail object

                } else {
                    throw new MailContentException();
                }
            } else {
                throw new AddressException();
            }
        } else {
            throw new MailBuilderException();
        }
    }

}
