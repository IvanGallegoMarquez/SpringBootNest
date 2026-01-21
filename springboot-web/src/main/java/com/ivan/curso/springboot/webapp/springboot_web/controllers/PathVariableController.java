package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;
import com.ivan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

@Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
private List<String> valueList;

@Value("#{'${config.listOfValues}'.toUpperCase()}")
private String valueString;

@Value("#{${config.valuesMap}}")
private Map<String, String> valuesMap;

@Value("#{${config.valuesMap}.product}")
private String product;

@Value("#{${config.valuesMap}.price}")
private Long price;

@Value("${config.listOfValues}")
private List<String> listOfValues;

// @Value("${config.message}")
// private String message;

@Autowired
private Environment environment;


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

    Long code3 = environment.getProperty("config.code3", Long.class);

    Map<String, Object> json = new HashMap<>();
    json.put("username", userName);
    json.put("code", code);
    json.put("message", message);
    json.put("message2", environment.getProperty("config.message"));
    json.put("code3", code3);
    json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
    json.put("listOfValues", listOfValues);
    json.put("valueList", valueList);
    json.put("valueString", valueString);
    json.put("valuesMap", valuesMap);
    json.put("product", product);
    json.put("price", price);

    return json;
}




}



