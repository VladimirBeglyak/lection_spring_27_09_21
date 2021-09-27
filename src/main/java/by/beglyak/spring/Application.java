package by.beglyak.spring;

import by.beglyak.spring.config.ApplicationConfiguration;
import by.beglyak.spring.dao.PersonDaoImpl;
import by.beglyak.spring.entity.Job;
import by.beglyak.spring.entity.Person;
import by.beglyak.spring.service.PersonService;
import by.beglyak.spring.service.PersonServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Person person = (Person) context.getBean("person");
        person.setName("Vladimir");
        person.setAge(20);
        System.out.println(person);

        Job job = (Job) context.getBean("job");
        job.setName("Ingeneer");
        System.out.println(job);

        person.setJobs(Arrays.asList(job));
        job.setPerson(person);

        PersonService personService = (PersonServiceImpl) context.getBean("personServiceImpl");
        personService.save(person);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
