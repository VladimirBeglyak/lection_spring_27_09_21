package by.beglyak.spring.util;

import by.beglyak.spring.entity.Job;
import by.beglyak.spring.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Person.class)
                        .addAnnotatedClass(Job.class)
                        .buildSessionFactory(new StandardServiceRegistryBuilder().build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;
    }
}
