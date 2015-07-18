package org.pnt.product.model.org.pnt.product.util;

import org.pnt.product.model.Person;

import java.util.Date;

/**
 * Created by Alexander on 18.07.2015.
 */
public class PersonBuilder {

    private Long id;
    private Long uuid;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthday;
    private Date createdAt;
    private Date updatedAt;

    public PersonBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setUuid(Long uuid) {
        this.uuid = uuid;
        return this;
    }

    public PersonBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder setBirthDay(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public PersonBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public PersonBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setId(id);
        person.setUuid(uuid);
        person.setEmail(email);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setBirthday(birthday);
        person.setCreatedAt(createdAt);
        person.setUpdatedAt(updatedAt);
        return person;
    }
}