package com.ivan.curso.springboot.webapp.springboot_web.models;

public class User {


    private String name;
    private String lastname;
    private Integer age;
    private String email;
    

    public User(String name, String lastname, Integer age, String email) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }
    
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLastname() {
    return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}
public Integer getAge() {
    return age;
}
public void setAge(Integer age) {
    this.age = age;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}


}
