package org.pnt.product.org.pnt.product.service;

import org.pnt.product.dao.GenericDao;
import org.pnt.product.dao.PersonDao;
import org.pnt.product.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alexander on 09.06.2015.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public Person createNewPerson(String email) {
        Person p = new Person();
        p.setEmail(email);

        return personDao.saveOrUpdate(p);
    }
}
