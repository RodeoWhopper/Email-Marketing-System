package com.service.daccess.conc;

import com.service.daccess.DataAccess;
import com.service.model.User;
import com.service.util.builders.conc.SessionFactoryBuilder;
import com.service.util.exceptions.database.UpdateObjectCannotBeNullException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDataAccess implements DataAccess<User> {

    private final SessionFactory sessionFactory;

    public UserDataAccess() {
        this.sessionFactory = new SessionFactoryBuilder().build();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from Target").list();
        session.close();
        return users;
    }

    @Override
    public void update(User user) {
        if(user != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            session.close();
        } else {
            throw new UpdateObjectCannotBeNullException();
        }
    }


}
