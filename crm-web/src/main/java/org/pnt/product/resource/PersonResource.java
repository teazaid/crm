package org.pnt.product.resource;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.pnt.product.org.pnt.product.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexander on 09.06.2015.
 */
@Controller
@RequestMapping(value = "/rest/person", produces = "application/json")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create() {
        personService.createNewPerson("");
        return "sds";
    }

    @JsonAutoDetect
    private class Resp {
        //personService.createNewPerson("sd");

        private String hello = "hello";
    }


}
