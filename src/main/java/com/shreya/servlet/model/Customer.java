 package com.shreya.servlet.model;

 import java.util.Objects;

 public class Customer {
    private int id;
    private String name;
    private String city;
    private int mobileNo;
    private int age;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", mobileNo=" + mobileNo +
                ", age=" + age +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     @Override
     public boolean equals(Object o) {
         if (o == null || getClass() != o.getClass()) return false;
         Customer customer = (Customer) o;
         return id == customer.id && mobileNo == customer.mobileNo;
     }

     @Override
     public int hashCode() {
         return Objects.hash(id, mobileNo);
     }
 }
