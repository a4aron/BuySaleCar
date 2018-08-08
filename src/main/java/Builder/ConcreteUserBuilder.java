package Builder;

import model.Car;
import model.User;

import java.util.List;

public class ConcreteUserBuilder extends UserBuilder {
    public ConcreteUserBuilder(String firstname, String lastName) {
        super(firstname, lastName);
    }

    @Override
    public UserBuilder ID(int id) {
        this.id = id;
        return this;
    }

    @Override
    public UserBuilder MiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public UserBuilder Email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public UserBuilder Address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public UserBuilder UserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public UserBuilder Password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserBuilder CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @Override
    public UserBuilder CardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
        return this;
    }

    @Override
    public UserBuilder CardSecurityCode(String cardSecurityNumber) {
        this.cardSecurityNumber = cardSecurityNumber;
        return this;
    }

    @Override
    public UserBuilder Cars(List<Car> cars) {
        this.cars = cars;
        return this;
    }

    @Override
    public User build() {
        return new User(this);
    }
}
