package Template;

import datastorage.DataStorage;
import genericmodel.Product;
import genericmodel.Rent;
import model.User;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class ConcreteRentProcessor extends RentProcessor {
    @Override
    protected void setCarRentFlag(int productID) {
        DataStorage.INSTANCE.setCarRentFlag(productID);
    }

    @Override
    protected void saveRent(Rent rent) {
        DataStorage.INSTANCE.addRent(rent);
    }

    @Override
    protected void sendNotification() {
            System.out.println("Email has been sent");
    }

    @Override
    protected Rent calculateRent(User user, Product product, Date startDate, Date endDate) {
       return new Rent(new Random().nextInt(10000-1) + 1,product,startDate,endDate,
               product.getPrice() *
                       30);
    }

    @Override
    protected Product getProduct(int productID) {
        return DataStorage.INSTANCE.getCarById(productID);
    }

    @Override
    protected User verifyUser(int userID) {
        return DataStorage.INSTANCE.getUserById(userID);
    }
}
