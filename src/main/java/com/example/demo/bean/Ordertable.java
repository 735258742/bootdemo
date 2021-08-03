package com.example.demo.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Ordertable {
    private String rentid;
    private String username;
    private String userid;
    private String carid;
    private String number;
    private String type;
    private String brand;
    private String color;
    private double rentprice;
    private double deposit;
    private double total;
    private Date begintime;
    private Date endtime;
    private String description;
    private String img;

    public Ordertable(String rentid, String username, String userid, String carid, String number, String type, String brand, String color, double rentprice, double deposit, double total, Date begintime, Date endtime, String description, String img) {
        this.rentid = rentid;
        this.username = username;
        this.userid = userid;
        this.carid = carid;
        this.number = number;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.rentprice = rentprice;
        this.deposit = deposit;
        this.total = total;
        this.begintime = begintime;
        this.endtime = endtime;
        this.description = description;
        this.img = img;
    }

    public Ordertable() {
    }

    public String getRentid() {
        return rentid;
    }

    public void setRentid(String rentid) {
        this.rentid = rentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public double getRentprice() {
        return rentprice;
    }

    public void setRentprice(double rentprice) {
        this.rentprice = rentprice;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

