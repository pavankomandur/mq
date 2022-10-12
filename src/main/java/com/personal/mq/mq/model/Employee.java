package com.personal.mq.mq.model;

import lombok.Data;

@Data
public class Employee {
    private String firstName;
    private int age;
    private String lastName;
    private String phone;
    private String taxId;
    private Address address;
    private String employmentStatus;


}
