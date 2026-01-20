package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;
import com.ivan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("api/var")
public class PathVariableController {

@Value("${config.username}")
private String userName;

@Value("${config.code}")
private String code;   

// @Value("${config.message}")
// private String message;

@Value("${config.listOfValues}")
private String[] listOfValues;



    
@GetMapping("/baz/{message}")
public ParamDto baz(@PathVariable String message) {
   
    ParamDto param = new ParamDto();
    param.setMessage(message);    
       return param;
}

@GetMapping("/mix/{product}/{id}")
public Map<String, Object>PathVar(@PathVariable String product, @PathVariable Long id){
    Map<String, Object> json = new HashMap<>();

    json.put("product", product);
    json.put("id", id);

    return json;
// ejemplo de ruta para ver que funciona correctamente en el navegador : http://localhost:8080/api/var/mix/cocacola/1234
}

@PostMapping("/create")
public User create(@RequestBody User user){
    

    user.setName(user.getName().toUpperCase());
    //Hacer algo con el usaurio (como un saver) en la BBDD
    return user;
}

@GetMapping("/values")
    public Map<String, Object> Values(@Value("${config.message}") String message){

    Map<String, Object> json = new HashMap<>();
    json.put("username", userName);
    json.put("code", code);
    json.put("message", message);
    json.put("listOfValues", listOfValues);

    return json;
}




}



