package genericmodel;

public abstract class Product {
    int id;
    double price;
    String name;

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    boolean isRented;

    public Product(int id, double price, String name,boolean isRented) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.isRented = isRented;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
