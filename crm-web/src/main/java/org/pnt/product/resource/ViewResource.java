package org.pnt.product.resource;

import org.pnt.product.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alexander on 07.08.2015.
 */
@Controller
@RequestMapping(value="/views")
public class ViewResource {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    public String helloView() {
        return "hello";
    }


    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public ModelAndView helloView1() {
        ModelAndView model = new ModelAndView("hello");
        Person person = new Person();
        person.setFirstName("Bob");
        model.addObject("myString", person);
        return model;
    }
}
