package org.pnt.product.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.pnt.product.NamedQueries;
import org.pnt.product.deserializer.PersonDeserializer;
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
@JsonDeserialize(using = PersonDeserializer.class)
public class Person implements Uuidable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long uuid;

    private String email;

    private String firstName;

    private String lastName;

    private String middleName;

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

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Person) {
            Person that = (Person) obj;
            if(this == that || (that.id != null && that.id.equals(this.id))) {
                return true;
            }

            if((this.birthday != null && !this.birthday.equals(that.birthday)) ||
                    (this.birthday == null && that.birthday != null)) {
                return false;
            }

            if((this.createdAt != null && !this.createdAt.equals(that.createdAt)) ||
                    (this.createdAt == null && that.createdAt != null)) {
                return false;
            }

            if((this.email != null && !this.email.equals(that.email)) ||
                    (this.email == null && that.email != null)) {
                return false;
            }

            if((this.firstName != null && !this.firstName.equals(that.firstName)) ||
                    (this.firstName == null && that.firstName != null)) {
                return false;
            }

            if((this.lastName != null && !this.lastName.equals(that.lastName)) ||
                    (this.lastName == null && that.lastName != null)) {
                return false;
            }

            if((this.middleName != null && !this.middleName.equals(that.middleName)) ||
                    (this.middleName == null && that.middleName != null)) {
                return false;
            }

            if((this.updatedAt != null && !this.updatedAt.equals(that.updatedAt)) ||
                    (this.updatedAt == null && that.updatedAt != null)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
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

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(email).append(StringUtils.SPACE)
                .append(firstName).append(StringUtils.SPACE)
                .append(lastName).append(StringUtils.SPACE)
                .append(middleName).append(StringUtils.SPACE)
                .append(birthday).append(StringUtils.SPACE)
                .append(createdAt).append(StringUtils.SPACE)
                .append(updatedAt).append(StringUtils.SPACE)
                .toString();
    }
}
