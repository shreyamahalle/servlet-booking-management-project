package com.shreya.servlet.model;

import java.util.Objects;

public class Restaurant {
    private int registerNo;
    private String name;
    private String City;
    private String Area;

    @Override
    public String toString() {
        return "Restaurant{" +
                "registerNo=" + registerNo +
                ", name='" + name + '\'' +
                ", City='" + City + '\'' +
                ", Area='" + Area + '\'' +
                '}';
    }

    public int getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(int registerNo) {
        this.registerNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return registerNo == that.registerNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(registerNo);
    }
}