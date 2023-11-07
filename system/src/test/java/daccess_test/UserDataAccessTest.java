package daccess_test;

import com.google.common.collect.Lists;
import com.service.model.User;
import com.service.util.builders.conc.SessionFactoryBuilder;
import com.service.util.enums.PurchaseMeta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.service.util.enums.PurchaseMeta.DRESSING;
import static com.service.util.enums.PurchaseMeta.TECHNOLOGY;

public class UserDataAccessTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp(){
        SessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryBuilder();
        sessionFactory = sessionFactoryBuilder.build();
    }

    @Test
    public void testAddUser(){
        
        Date now = Date.valueOf(LocalDate.now());
        ArrayList<PurchaseMeta> list = Lists.newArrayList(TECHNOLOGY,DRESSING);
        User user = new User(
                "Emirhan",
                "Bulut",
                "emirhan9@gmail.com",
                now,
                list);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Long userId = (Long) session.save(user);

        transaction.commit();
        session.close();

        Assert.assertNotNull(userId);

        session = sessionFactory.openSession();
        User addedUser = session.get(User.class,userId);
        session.close();

        Assert.assertNotNull(addedUser);
        Assert.assertEquals("Emirhan",addedUser.getName());
        Assert.assertEquals("Bulut",addedUser.getSurname());
        Assert.assertEquals("emirhan9@gmail.com",addedUser.getEmailAddress());
        Assert.assertEquals(now,addedUser.getLastPurchaseDate());
        Assert.assertEquals(list,addedUser.getPurchaseMeta());

    }

    @AfterClass
    public static void tearDown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
