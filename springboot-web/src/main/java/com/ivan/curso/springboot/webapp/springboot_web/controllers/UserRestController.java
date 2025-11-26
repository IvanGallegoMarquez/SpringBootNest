package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;



@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path ="/details")
    public Map<String, Object> details() {
    User user=new User("Andres", "Guzman", 29,"andresGuzman@gmail.com");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Springboot");
        body.put("user", user);   
        return body;

    }


}
