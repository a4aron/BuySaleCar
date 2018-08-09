package model;

import genericmodel.Product;

import java.util.Date;

public class Car extends Product {

    private String license;
    private String brand;
    private String color;
    private String shape;
    private boolean isSold;
    private Date date;
    private double discount;
    private String image;
    private User owner;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Car(int id, String license, String model, String brand, double price, String color, String shape,
               boolean isSold, Date date, double discount, String image, User owner,boolean isRented) {
        super(id,price,model,isRented);
        this.license = license;
        this.brand = brand;
        this.color = color;
        this.shape = shape;
        this.isSold = isSold;

        this.date = date;
        this.discount = discount;
        this.image = image;
        this.owner = owner;
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

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getOwner(){
        return this.owner;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
