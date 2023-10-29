package com.service.tasks;

import com.service.manager.UserManager;
import com.service.model.User;
import com.service.util.UserUtil;
import com.service.util.enums.Datum;

import java.util.List;
import java.util.stream.Collectors;

public class DataControlTask implements Runnable {

    private UserManager userManager;

    @Override
    public void run() {
        List<User> userList = this.userManager.getAll(), fiveDays, thirtyDays;

        fiveDays = userList.stream()
                .filter(user -> UserUtil.checkForDate(user) == Datum.MORE_THAN_5)
                .collect(Collectors.toList());

        thirtyDays = userList.stream()
                .filter(user -> UserUtil.checkForDate(user) == Datum.MORE_THAN_30)
                .collect(Collectors.toList());


    }

}
