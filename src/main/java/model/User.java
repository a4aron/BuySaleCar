package model;

import Builder.UserBuilder;

import java.util.List;

public class User {
    private int id;
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private transient String userName;
    private transient String password;

    private String middleName;
    private String cardNumber;
    private String cardExpiryDate;
    public String cardSecurityNumber;

    private List<Car> cars;

    public User(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.firstname = userBuilder.firstname;
        this.email =userBuilder.email;
        this.phoneNumber = userBuilder.phoneNumber;
        this.address = userBuilder.address;
        this.userName = userBuilder.userName;
        this.password = userBuilder.password;
        this.middleName = userBuilder.middleName;
        this.cardNumber = userBuilder.cardNumber;
        this.cardExpiryDate = userBuilder.cardExpiryDate;
        this.cardSecurityNumber = userBuilder.cardSecurityNumber;
        this.cars = userBuilder.cars;
    }

   /* public User(int id, String firstname, String lastName, String email, String phoneNumber, String address,
                String userName, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }*/
    public User() {

    }

    public int getId() {
        return id;
    }

   /* public void setId(int id) {
        this.id = id;
    }*/

    public String getFirstname() {
        return firstname;
    }

  /*  public void setFirstname(String firstname) {
        this.firstname = firstname;
    }*/

    public String getLastName() {
        return lastName;
    }

  /*  public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

    public String getEmail() {
        return email;
    }

   /* public void setEmail(String email) {
        this.email = email;
    }*/

    public String getPhoneNumber() {
        return phoneNumber;
    }

   /* public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

   /* public void setUserName(String userName) {
        this.userName = userName;
    }*/

    public String getPassword() {
        return password;
    }

   /* public void setPassword(String password) {
        this.password = password;
    }*/
    public List<Car> getCars() {
        return cars;
    }

   /* public void setCars(List<Car> cars) {
        this.cars = cars;
    }*/

   public String getCardNumber(){
       return cardNumber;
   }
    public String getCardExpiryDate(){
        return cardExpiryDate;
    }
    public String getCardSecurityNumber(){
        return cardSecurityNumber;
    }

}
