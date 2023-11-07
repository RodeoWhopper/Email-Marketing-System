package com.service.tasks;

import com.service.manager.UserManager;
import com.service.model.Mail;
import com.service.model.User;
import com.service.util.enums.Topic;
import com.service.util.exceptions.other.SynchronizationException;
import com.service.util.other.JsonUtil;
import com.service.util.other.UserUtil;
import com.service.util.builders.conc.MailBuilder;
import com.service.util.enums.Datum;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DataControlTask extends Thread {

    private static UserManager userManager;
    private static MailBuilder mailBuilder;

    @Override
    public void run() {
        List<User> userList = userManager.getAll(), fiveDays, thirtyDays;

        fiveDays = userList.stream()
                .filter(user -> UserUtil.checkForDate(user) == Datum.MORE_THAN_5)
                .collect(Collectors.toList());

        thirtyDays = userList.stream()
                .filter(user -> UserUtil.checkForDate(user) == Datum.MORE_THAN_30)
                .collect(Collectors.toList());

        sendEmailsToUsersInList(fiveDays, Topic.FIVE_DAYS);
        sendEmailsToUsersInList(thirtyDays, Topic.THIRTY_DAYS);

    }

    private static void sendEmailsToUsersInList(List<User> list, Topic topic){

        list.forEach(user -> {

            String receiver = user.getEmailAddress(),
                    sender = JsonUtil.getEmailAccount()[0],
                    password = JsonUtil.getEmailAccount()[1],
                    smtpServer = JsonUtil.getSmtpAddress()[0],
                    smtpPort = JsonUtil.getSmtpAddress()[1];

            Mail mail = mailBuilder.build(receiver,sender,password,smtpServer,smtpPort,topic.name());

            SendMailTask sendMailTask = new SendMailTask(mail);
            sendMailTask.start();

            try {
                sendMailTask.join();
            } catch (InterruptedException e) {
                throw new SynchronizationException();
            }

            updateUser(user);

        });
    }

    private static void updateUser(User user){
        LocalDate now = LocalDate.now();
        user.setLastPurchaseDate(Date.valueOf(now));
        userManager.update(user);
    }



}
