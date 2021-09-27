package by.beglyak.spring.dao;

import java.util.List;

public interface PersonDao<I,P> {

    List<P> findAll();
    void save(P p);
    void delete(I id);
    void update(P p);
    P findById(I id);

}
