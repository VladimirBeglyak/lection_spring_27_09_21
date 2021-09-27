package by.beglyak.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService<I,P> {

    List<P> findAll();
    void save(P p);
    void delete(I id);
    void update(P p);
    P findById(I id);

}
