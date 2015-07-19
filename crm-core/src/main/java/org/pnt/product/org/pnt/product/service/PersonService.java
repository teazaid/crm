package org.pnt.product.org.pnt.product.service;

import org.pnt.product.NamedQueries;
import org.pnt.product.dao.PersonDao;
import org.pnt.product.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alexander on 09.06.2015.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public Person createNewPerson(Person person) {
        return personDao.saveOrUpdate(person);
    }

    public Collection<Person> findByUuid(long uuid) {
        return personDao.findByQuery(NamedQueries.Person.BY_UUID, Person.class, uuid);
    }


}
