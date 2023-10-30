package com.service.util.builders.conc;

import com.service.util.builders.Builder;
import com.service.util.exceptions.InitializerException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder implements Builder<SessionFactory> {
    @Override
    public SessionFactory build(String... args) throws InitializerException {
        try{
            Configuration config = new Configuration().configure("hibernate.cfg.xml");//Create a config with hibernate config
            return config.buildSessionFactory();//Build the factory and return it
        } catch (Throwable err) {
            System.out.println("Somethings went wrong on create SessionFactory");
            throw new InitializerException(err.getMessage());//Throw custom exception on error
        }
    }
}
