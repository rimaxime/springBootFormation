package com.mriviere.firstmicroservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/myapp")
public class MyAppRessource {

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable("id") int id) {
        return "MY APP IS WORKING FOR ID " + id;
    }

    @GetMapping(path = "/all")
    public String getAll() {
        return "MY APP IS WORKING FOR ALL";
    }
}
