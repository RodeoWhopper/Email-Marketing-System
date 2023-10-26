package com.service.daccess.conc;

import com.service.daccess.DataAccess;
import com.service.model.Target;
import com.service.util.builders.conc.SessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TargetDataAccess implements DataAccess<Target> {

    private final SessionFactory sessionFactory;

    public TargetDataAccess() {
        this.sessionFactory = new SessionFactoryBuilder().build();
    }

    @Override
    public Target getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Target target = session.get(Target.class,id);
        transaction.commit();
        session.close();
        return target;
    }

    @Override
    public List<Target> getAll() {
        Session session = sessionFactory.openSession();
        List<Target> targets = session.createQuery("from Target").list();
        session.close();
        return targets;
    }
}
