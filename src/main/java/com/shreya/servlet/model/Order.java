package com.shreya.servlet.model;

import java.util.Objects;

public class Order {
    private int id;
    private String type;
    private String note;
    private String paymentMethod;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
