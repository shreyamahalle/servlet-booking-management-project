package com.shreya.servlet.model;

import java.util.Objects;

public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    private int mobileNo;

    @Override
    public String toString() {
        return "DeliveryAgent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAgent that = (DeliveryAgent) o;
        return id == that.id && mobileNo == that.mobileNo && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobileNo);
    }
}
