package org.pnt.product.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.pnt.product.model.Person;
import org.pnt.product.utils.DateUtils;
import org.pnt.product.utils.PersonBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Alexander on 18.07.2015.
 */

public class PersonDeserializer extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode jsonNode = codec.readTree(jsonParser);
        // TODO cover with the tests
        return new PersonBuilder()
                .setBirthDay(jsonNodeToDate(jsonNode, BIRTH_DAY))
                .setCreatedAt(jsonNodeToDate(jsonNode, CREATED_AT))
                .setEmail(jsonNodeToString(jsonNode, EMAIL))
                .setFirstName(jsonNodeToString(jsonNode, FIRST_NAME))
                .setId(jsonNodeToLong(jsonNode, ID))
                .setLastName(jsonNodeToString(jsonNode, LAST_NAME))
                .setMiddleName(jsonNodeToString(jsonNode, MIDDLE_NAME))
                .setUpdatedAt(jsonNodeToDate(jsonNode, UPDATED_AT))
                .setUuid(jsonNodeToString(jsonNode, UUID))
        .build();
    }

    private Date jsonNodeToDate(JsonNode node, String key) {
        Date result = null;
        try {
            result = DateUtils.convertToDate(jsonNodeToString(node, key));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String jsonNodeToString(JsonNode node, String key) {
        JsonNode jsonNode = node.get(key);
        return jsonNode == null ? null : jsonNode.textValue();
    }

    private Long jsonNodeToLong(JsonNode node, String key) {
        JsonNode jsonNode = node.get(key);
        return jsonNode == null ? null : jsonNode.longValue();
    }

    private static final String BIRTH_DAY = "birthDay";
    private static final String CREATED_AT = "createdAt";
    private static final String EMAIL = "email";
    private static final String FIRST_NAME = "firstName";
    private static final String ID = "id";
    private static final String LAST_NAME = "lastName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String UPDATED_AT = "updatedAt";
    private static final String UUID = "uuid";
}
