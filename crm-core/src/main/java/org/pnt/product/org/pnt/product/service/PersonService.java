package org.pnt.product.org.pnt.product.service;

import org.pnt.product.dao.AbstractDao;
import org.pnt.product.model.Person;

/**
 * Created by Alexander on 09.06.2015.
 */
public class PersonService {
    private AbstractDao<Person> personDao;

    public Person createNewPerson(String email) {
        Person p = new Person();
        p.setEmail(email);

        return personDao.saveOrUpdate(p);
    }
}
