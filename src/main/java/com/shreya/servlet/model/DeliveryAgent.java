package com.shreya.servlet.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    public int mobileNo;

}
