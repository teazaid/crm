package org.pnt.product.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.pnt.product.NamedQueries;
import org.pnt.product.listeners.UuidListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alexander on 08.06.2015.
 */
@javax.persistence.NamedQueries({
        @NamedQuery(name = NamedQueries.Person.BY_UUID, query = "select p from Person p where p.uuid = ?1"),
        @NamedQuery(name = NamedQueries.Person.BY_EMAIL, query = "select p from Person p where p.email = ?1")
})
@Entity
@EntityListeners(value = {UuidListener.class})
public class Person implements Serializable, Uuidable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String firstName;
    private String lastName;
    private String middleName;
    private long uuid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(email)
                .append(firstName)
                .append(lastName)
                .append(middleName)
                .append(birthday)
                .append(createdAt)
                .append(updatedAt)
                .toHashCode();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }
}
