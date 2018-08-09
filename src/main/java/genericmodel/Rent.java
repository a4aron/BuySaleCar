package genericmodel;

import java.util.Date;

public class Rent {
    int ID;
    Product product;
    Date startDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    Date endDate;
    double total;

    public Rent(int ID, Product product, Date startDate, Date endDate, double total) {
        this.ID = ID;
        this.product = product;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
    }
}
