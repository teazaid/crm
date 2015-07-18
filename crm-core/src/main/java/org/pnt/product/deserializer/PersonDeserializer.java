package org.pnt.product.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
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
                .setBirthDay(jsonNodeToDate(jsonNode, "birthDay"))
                .setCreatedAt(jsonNodeToDate(jsonNode, "createdAt"))
                .setEmail(jsonNode.get("email").textValue())
                .setFirstName(jsonNode.get("firsName").textValue())
                .setId(jsonNode.get("id").asLong())
                .setLastName(jsonNode.get("lastName").textValue())
                .setMiddleName(jsonNode.get("middleName").textValue())
                .setUpdatedAt(jsonNodeToDate(jsonNode, "updatedAt"))
                .setUuid(jsonNode.get("uuid").asLong())
            .build();
    }

    private Date jsonNodeToDate(JsonNode node, String key) {
        Date result = null;
        try {
            result = DateUtils.convertToDate(getDateString(node, key));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result == null ? DateUtils.now() : result;
    }

    private String getDateString(JsonNode node, String key) {
        String result = node.get(key).textValue();

        //return result == null ? DateUtils.convertToString(DateUtils.now()): result ;
        return result;
    }
}
