package Factory;

import model.User;

public class CreateUserFactory implements CreateFactory{
    @Override
    public User createUser() {
        return new User();
    }
}
