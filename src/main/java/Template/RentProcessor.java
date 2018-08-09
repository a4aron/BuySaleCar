package Template;

import genericmodel.Product;
import genericmodel.Rent;
import model.User;

import java.util.Date;

public abstract class RentProcessor {
    public  boolean doRent(int userID, int productID, Date startDate, Date endDate){
        User user = verifyUser(userID);
        if(user != null) {
            Product product = getProduct(productID);
            if(product !=  null) {
                Rent rent = calculateRent(user, product, startDate, endDate);
                saveRent(rent);
                setCarRentFlag(productID);
                sendNotification();
                return true;
            }
        }
        return false;
    }

    protected abstract void setCarRentFlag(int productID);

    protected abstract void saveRent(Rent rent);

    protected abstract void sendNotification();

    protected abstract Rent calculateRent(User user, Product product, Date startDate, Date endDate);

    protected abstract Product getProduct(int productID);

    protected abstract User verifyUser(int userID);
}
