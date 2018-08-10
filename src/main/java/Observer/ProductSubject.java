package Observer;

import model.User;

public interface ProductSubject {
    void addObserver(User user);
    void removeObserver(User user);
    void notifyAllObservers();
}
