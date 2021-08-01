package com.example.demo.bean;

public class Car {

    private String carid;
    private String number;
    private String type;
    private String brand;
    private String color;
    private String price;
    private String rentprice;
    private String deposit;
    private String isrenting;
    private String vehiclequality;
    private String description;
    private String img;

    public Car(String carid, String number, String type, String brand, String color, String price, String rentprice, String deposit, String isrenting, String vehiclequality, String description, String img) {
        this.carid = carid;
        this.number = number;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.rentprice = rentprice;
        this.deposit = deposit;
        this.isrenting = isrenting;
        this.vehiclequality = vehiclequality;
        this.description = description;
        this.img = img;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVehiclequality() {
        return vehiclequality;
    }

    public void setVehiclequality(String vehiclequality) {
        this.vehiclequality = vehiclequality;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRentprice() {
        return rentprice;
    }

    public void setRentprice(String rentprice) {
        this.rentprice = rentprice;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(String isrenting) {
        this.isrenting = isrenting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
