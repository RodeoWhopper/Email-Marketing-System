package com.service.manager;

import com.service.daccess.DataAccess;
import com.service.model.User;

import java.util.List;

public class UserManager {
    private DataAccess<User> dataAccess;

    public UserManager(DataAccess<User> dataAccess) {
        this.dataAccess = dataAccess;
    }

    public User getById(int id){
        return this.dataAccess.getById(id);
    }

    public List<User> getAll(){
        return this.dataAccess.getAll();
    }

    public void update(User user){
        this.dataAccess.update(user);
    }


}
