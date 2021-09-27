package by.beglyak.spring.config;


import by.beglyak.spring.entity.Job;
import by.beglyak.spring.entity.Person;
import by.beglyak.spring.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.beglyak.spring")
public class ApplicationConfiguration {

    @Bean
    public Person person() {
        Person person = new Person();
        return person;
    }

    @Bean
    public Job job() {
        Job job = new Job();
        return job;
    }

    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory;

        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        sessionFactory = configuration
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Job.class)
                .buildSessionFactory(new StandardServiceRegistryBuilder().build());

        return sessionFactory;
    }

}
