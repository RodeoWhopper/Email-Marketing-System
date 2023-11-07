package daccess_test;

import com.service.util.builders.conc.SessionFactoryBuilder;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataAccessTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp(){
        SessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryBuilder();
        sessionFactory = sessionFactoryBuilder.build();
    }

    @Test
    public void testHibernateConnection(){
        Assert.assertNotNull("Session Factory oluşturulamamış, hibernate ile veritabanına bağlantı sağlanamadı.", sessionFactory);
    }

    @AfterClass
    public static void tearDown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
