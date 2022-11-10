package com.epam.autocode.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User(Long id, Character startWith) {
        this.id = id;
        firstName = generateString(startWith.toString().toUpperCase() + "_first name ");
        lastName = generateString(startWith.toString().toUpperCase() + "_last name ");
        age = Math.toIntExact(this.id);
    }

    private String generateString(String str) {
        return str;
    }
}
