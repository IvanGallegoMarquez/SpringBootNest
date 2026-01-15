package com.ivan.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;
import com.ivan.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public UserDto details() {

         User user= new User("Andres", "Guzman",29,"andresGuzman@gmail.com");
        
        UserDto userDto = new UserDto();
       
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot");

        return userDto;
    }

    @GetMapping(path="/list")
    public List<User> list() {

        User user1= new User("Andres", "Guzman", 18, "AndresGuzman@gmail.com");
        User user2= new User("Juan", "Gomez", 25, "JuanAntonio@gmail.com");
        User user3= new User("Federico", "Garcia", 68, "FedericoGarcia@gmail.com");
        
        //Dos metodos similares, el activo sin cometnar es para reducir lina de codigo        
        List<User> users = Arrays.asList(user1, user2, user3);
        //List<User> users = new ArrayList<>();
        //users.add(user1);
        //users.add(user2);
        //users.add(user3);
        return users;
    }
        

    @RequestMapping(path ="/details-map")
    public Map<String, Object> detailsMap() {
    
        User user=new User("Andres", "Guzman", 29,"andresGuzman@gmail.com");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Springboot");
        body.put("user", user);   
        return body;

    }


}
