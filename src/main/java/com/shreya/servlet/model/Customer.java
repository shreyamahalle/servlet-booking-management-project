package com.shreya.servlet.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Customer {
    private int id;
    private String name;
    private String city;
    private int mobileNo;
    private int age;


}
