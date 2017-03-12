package com.mriviere.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
public class ToDoController {
    @RequestMapping(method = RequestMethod.GET)
    //TODO implement sayHello
    public String sayHello(ModelMap model) {
        return "todo";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    //todo improve sayHelloAgain implementation
    public String sayHelloAgain(ModelMap model) {
        return "todo";
    }
}
