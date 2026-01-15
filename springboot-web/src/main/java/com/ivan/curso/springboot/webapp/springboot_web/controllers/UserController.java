package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import java.util.List;
import java.util.Arrays;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {


    
    
    @GetMapping("/details")
    public String details(Model model) {
    
        User user=new User("Andres", "Guzman", 29,"andresGuzman@gmail.com");
        model.addAttribute("title", "Hola Mundo Springboot");
        model.addAttribute("user", user);
             return "details";

    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        // List<User> users =  Arrays.asList(
        //     new User("Manolo","Fernandez",62, "manolofernandez@gmail.com"),
        //     new User("Ana","Lopez",33, "Analopez@gmail.com"),
        //     new User("Laura","Martinez",27)
        // );




        // model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    
    
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
        
             new User("Manolo","Fernandez",62, "manolofernandez@gmail.com"),
             new User("Ana","Lopez",33, "Analopez@gmail.com"),
             new User("Laura","Martinez",27));
         
        }

}
