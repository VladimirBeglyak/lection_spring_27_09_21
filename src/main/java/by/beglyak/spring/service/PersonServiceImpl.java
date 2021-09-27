package by.beglyak.spring.service;

import by.beglyak.spring.dao.PersonDao;
import by.beglyak.spring.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService<Long,Person> {

    @Autowired
    private PersonDao<Long,Person> personDao;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(Long id) {
        personDao.delete(id);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public Person findById(Long id) {
        return personDao.findById(id);
    }
}
