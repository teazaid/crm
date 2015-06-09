package org.pnt.product.resource;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Alexander on 09.06.2015.
 */
@Controller
@RequestMapping(value = "/rest/person")
public class PersonResource {
    @RequestMapping(value = "/create", method = RequestMethod.POST)

    public String create() {
        return "sds";
    }

    @JsonAutoDetect
    private class Resp {
        private String hello = "hello";
    }
}
