package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.ivan.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/params")
public class RequestParamControllers {
    

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "no se ha enviado ningun mensaje") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    } 
    

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam Integer code)
    {
            ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
            return params;
    }
        

}
