package Builder;

import model.Car;
import model.User;

import java.util.List;

public abstract class UserBuilder {
    public int id;
    public String firstname;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String address;
    public transient String userName;
    public transient String password;
    public String middleName;
    public String cardNumber;
    public String cardExpiryDate;
    public String cardSecurityNumber;
    public List<Car> cars;


    public UserBuilder(String firstname, String lastName){
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public abstract UserBuilder ID(int id);
    public abstract UserBuilder MiddleName(String middleName);
    public abstract UserBuilder Email(String email);
    public abstract UserBuilder PhoneNumber(String phoneNumber);
    public abstract UserBuilder Address(String address);
    public abstract UserBuilder UserName(String userName);
    public abstract UserBuilder Password(String password);
    public abstract UserBuilder CardNumber(String cardNumber);
    public abstract UserBuilder CardExpiryDate(String cardExpiryDate);
    public abstract UserBuilder CardSecurityCode(String cardSecurityNumber);
    public abstract UserBuilder Cars(List<Car> cars);
    
    public abstract User build();

}
