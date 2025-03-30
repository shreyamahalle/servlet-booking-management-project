package com.shreya.servlet.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Restaurant {
    private int registerNo;
    private String name;
    private String City;
    private String Area;

}