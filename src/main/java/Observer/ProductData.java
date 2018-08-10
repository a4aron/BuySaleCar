package Observer;

import genericmodel.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;

public enum ProductData implements ProductSubject {
    INSTANCE;
    private Product product;
   static List<User> observers = new ArrayList<>();
    @Override
    public void addObserver(User user) {
        if(!observers.contains(user))
        observers.add(user);
    }

    @Override
    public void removeObserver(User user) {
        observers.remove(user);
    }

    public  void setProduct(Product product){
        this.product = product;
        notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (User user: observers
             ) {
                user.update(this.product);
        }
    }
}
