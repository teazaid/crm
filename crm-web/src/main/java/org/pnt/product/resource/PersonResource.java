package org.pnt.product.resource;


import org.pnt.product.model.Person;
import org.pnt.product.org.pnt.product.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alexander on 09.06.2015.
 */
@Controller
@RequestMapping(value = "/rest/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonResource {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person create(@RequestBody Person person) {
        return personService.createNewPerson(person);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    @ResponseBody
    public Person findByUuid(@PathVariable("uuid") long uuid) {
        return personService.findByUuid(uuid).iterator().next();
    }
}
