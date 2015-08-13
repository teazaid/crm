package org.pnt.product.resource;

import org.pnt.product.NamedQueries;
import org.pnt.product.model.Person;
import org.pnt.product.org.pnt.product.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alexander on 08.08.2015.
 */
@Controller
public class WelcomeResource {
    @Autowired
    private PersonService personService;

    @RequestMapping({"/","/welcome"})
    public String welcomePage() {
        return "welcome";
    }

    @RequestMapping("/addPerson")
    public ModelAndView addPerson() {
        ModelAndView result = new ModelAndView("addPerson", "command", new Person());
        return result;
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addPerson(@ModelAttribute Person person) {
        ModelAndView result = new ModelAndView("personList");
        personService.createNewPerson(person);
        result.addObject("persons", personService.findByNamedQuery(NamedQueries.Person.SELECT_ALL));
        return result;
    }
}
