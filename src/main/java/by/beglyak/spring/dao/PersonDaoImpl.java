package by.beglyak.spring.dao;

import by.beglyak.spring.entity.Person;
import by.beglyak.spring.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao<Long, Person>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List allPerson = session.createQuery("select p from Person p").getResultList();
        return allPerson;
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public Person findById(Long id) {
        return null;
    }


}
