package org.pnt.product.model;

import org.pnt.product.model.org.pnt.product.util.PersonBuilder;
import org.pnt.product.utils.DateUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by Alexander on 18.07.2015.
 */
public class PersonTest {
    @Test(dataProvider = "persons")
    public void testEquals(Person p1, Person p2, boolean result) {
        Assert.assertEquals(p1.equals(p2), result);
        Assert.assertEquals(p2.equals(p1), result);
    }

    @DataProvider
    public Object[][] persons() {
        Date now = DateUtils.now();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1989l);
        Date notNow = calendar.getTime();
        String testEmail = "testEmail";
        String testFirstName = "testFirstName";
        String testLastName = "testLastName";
        String testMiddleName = "testMiddleName";

        Person fullPerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setId(0l)
                .setUuid(777l)
                .build();

        Person fullPerson2 = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();

        Person emptyPerson = new PersonBuilder().build();
        Person idPerson = new PersonBuilder().setId(0l).build();

        Person diffNamePerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testLastName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();

        Person diffLastNamePerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testFirstName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();
        Person diffMiddleNamePerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testLastName)
                .setUuid(777l)
                .build();

        Person diffEmailPerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testFirstName)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testLastName)
                .setUuid(777l)
                .build();

        Person diffBirthdayPerson = new PersonBuilder()
                .setBirthDay(notNow)
                .setCreatedAt(now)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();

        Person diffCreatedAtPerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(notNow)
                .setUpdatedAt(now)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();

        Person diffUpdatedAtPerson = new PersonBuilder()
                .setBirthDay(now)
                .setCreatedAt(now)
                .setUpdatedAt(notNow)
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setMiddleName(testMiddleName)
                .setUuid(777l)
                .build();

        return new Object[][] {
                new Object[]{fullPerson, fullPerson, true},
                new Object[]{fullPerson, fullPerson2, true},
                new Object[]{fullPerson, idPerson, true},
                new Object[]{fullPerson, emptyPerson, false},
                new Object[]{fullPerson, diffEmailPerson, false},
                new Object[]{fullPerson, diffNamePerson, false},
                new Object[]{fullPerson, diffLastNamePerson, false},
                new Object[]{fullPerson, diffMiddleNamePerson, false},
                new Object[]{fullPerson, diffBirthdayPerson, false},
                new Object[]{fullPerson, diffCreatedAtPerson, false},
                new Object[]{fullPerson, diffUpdatedAtPerson, false},

        };
    }

}
