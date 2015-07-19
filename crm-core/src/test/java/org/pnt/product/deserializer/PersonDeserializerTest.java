package org.pnt.product.deserializer;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.pnt.product.model.Person;
import org.pnt.product.utils.DateUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Alexander on 19.07.2015.
 */
public class PersonDeserializerTest {
    @BeforeClass
    public void init() {
        mapper = new ObjectMapper();
        // basic module metadata just includes name and version (both for troubleshooting; but name needs to be unique)
        SimpleModule module = new SimpleModule("PersonDeserializerTest", new Version(0, 1, 0, "alpha"));
        // functionality includes ability to register serializers, deserializers, add mix-in annotations etc:
        module.addDeserializer(Person.class, new PersonDeserializer());
        // and the magic happens here when we register module with mapper:
        mapper.registerModule(module);
    }

    @Test
    public void testDeserializer() throws IOException, ParseException {
        Person p = mapper.readerFor(Person.class).readValue(
                "{\n" +
                "\"email\":\"mail\",\n" +
                "\"birthDay\":\"1989-03-11 00:00:00\",\n" +
                "\"createdAt\":\"1989-01-11 00:00:00\",\n" +
                "\"updatedAt\":\"1989-02-11 00:00:00\",\n" +
                "\"firstName\":\"Alexander\",\n" +
                "\"lastName\":\"Zaidel\",\n" +
                "\"middleName\":\"Igorevich\",\n" +
                "\"id\":1," +
                "\"uuid\":7777" +
                "}"
        );

        Assert.assertEquals(p.getEmail(), "mail");
        Assert.assertEquals(p.getCreatedAt().equals(DateUtils.convertToDate("1989-01-11 00:00:00")), true);
        Assert.assertEquals(p.getUpdatedAt().equals(DateUtils.convertToDate("1989-02-11 00:00:00")), true);
        Assert.assertEquals(p.getBirthday().equals(DateUtils.convertToDate("1989-03-11 00:00:00")), true);
        Assert.assertEquals(p.getFirstName(), "Alexander");
        Assert.assertEquals(p.getLastName(), "Zaidel");
        Assert.assertEquals(p.getMiddleName(), "Igorevich");
        Assert.assertEquals(p.getId().equals(1L), true);
        Assert.assertEquals(p.getUuid().equals(7777L), true);
    }

    private ObjectMapper mapper;
}
