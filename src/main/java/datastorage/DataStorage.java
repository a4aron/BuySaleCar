package datastorage;

import Builder.ConcreteUserBuilder;
import Builder.UserBuilder;
import exceptions.CarAlreadyExistsException;
import exceptions.UserAlreadyExistsException;
import genericmodel.Rent;
import model.Car;
import model.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.*;
import Command.*;

public enum DataStorage {

    INSTANCE;

    private List<Car> cars = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Rent> rents = new ArrayList<>();
    public String[] carBrands = {"Mercedes","BMW","Toyota","Audi","Tesla","Ford","Cadillac","Mazda","Buick",
            "Chevrolet","Lexus","Other"};
    public String[] carShapes = {"Sedan","SUV","Van","Hatchback","Truck","Crossover","Coupe","Convertible"};
    public Map<String, String>  cookieMap = new HashMap<>();
    public Command command = new BackupCommand();
    public void loadDefaultData(){

        User u1 = new ConcreteUserBuilder("arun","magar").MiddleName("Thapa").Email("arun.magar@gmail.com").PhoneNumber("123456789").
                Address("1000N St. Maharishi").UserName("arun").Password("12345").build();
        User u2 = new ConcreteUserBuilder("bishwa","khatri").Email("bishwa.khatri@gmail.com").PhoneNumber("123456789").
                Address("1000N St. Maharishi").UserName("bishwa").Password("12345").build();
        User u3 = new ConcreteUserBuilder("Zhuang","niu").Email("zhuang@gmail.com").PhoneNumber("123456789").
                Address("1000N St. Maharishi").UserName("zhuang").Password("12345").build();
        users.add(u1);
        users.add(u2);
        users.add(u3);



        cars.add(new Car(1, "GNG 123","2000", carBrands[0], 7400, "red","Sedan", false,
                new Date(), 0, "resources/images/benz.jpg", u1,false));
        cars.add(new Car(2, "GYT 543","2000", carBrands[1], 23000, "red","SUV", false,
                new Date(), 0, "resources/images/bmw1.jpg", u1,false));
        cars.add(new Car(3, "GNG 654","2000", carBrands[2], 6700, "red","Van", false,
                new Date(), 0, "resources/images/rav4.jpg",u2,false));
        cars.add(new Car(4, "PYT 123","2000", carBrands[3], 19000, "red","Hatchback", false,
                new Date(), 0, "resources/images/audi.jpg",u2,false));
        cars.add(new Car(5,"MGT 123","2000", carBrands[4], 43000, "red","Crossover", false,
                new Date(), 0, "resources/images/van.jpg",u3,false));
        cars.add(new Car(6, "CFT 123","2000", carBrands[5], 5900, "red","Coupe", false,
                new Date(), 0, "resources/images/mazda1.jpg",u3,false));
        cars.add(new Car(7, "TGD 123","2000", carBrands[2], 29900, "red","Crossover", false,
                new Date(), 0, "resources/images/pickup1.jpg",u3,false));
        cars.add(new Car(8, "RHI 123","2000", carBrands[1], 20000, "red","Convertible", false,
                new Date(), 0, "resources/images/benzA.jpg",u1,false));
        cars.add(new Car(9, "BPT 123","2000", carBrands[6], 52000, "red","Truck", false,
                new Date(), 0, "resources/images/bmw2.jpg",u2,false));
        cars.add(new Car(10, "JVT 123","2000", carBrands[7], 25000, "red","Sedan", false,
                new Date(), 0, "resources/images/pickup2.jpg",u2,false));

        rents.add(new Rent(1,cars.get(0),new Date(2017,12,25),new Date(2017,12,1),1245));

       // System.out.println("=======>>>>data loaded");
    }

    public Car addCar(Car car) throws CarAlreadyExistsException {
        if (getCarByLicense(car.getLicense()) != null){
            throw new CarAlreadyExistsException("Car already exists");
        }
        command.backup(getAllCars());
        cars.add(car);
        return car;
    }

    public User addUser(User user) throws UserAlreadyExistsException {
        if (getUserByUsername(user.getUserName()) != null){
            throw new UserAlreadyExistsException("User already exists");
        }
        users.add(user);
        return user;
    }


    public Car getCarById(int id){
        for (Car car : cars){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllCars(){
        return reverseList(cars);
    }

    private List<Car> reverseList(List<Car> l) {
        List<Car> newList = new ArrayList<>();
        newList.addAll(l);
        Collections.reverse(newList);
        return newList;
    }

    public User getUserById(int id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username){
        for (User user : users){
           // System.out.println(user.getUserName());
            if (user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    public User getUserByUsernameAndPw(String username, String password){
        for (User user : users){
            if (user.getUserName().equals(username)
                    && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public Car getCarByLicense(String license){
        for (Car car : cars){
            if (car.getLicense() == license){
                return car;
            }
        }
        return null;
    }

    public void RestoreCars() {
        this.cars = reverseList(command.restore().getCars());
    }

    public Rent addRent(Rent rent) {
        rents.add(rent);
        return rent;
    }

    public Rent getRent(int id) {
        for (Rent rent : rents){
            if (rent.getID() == id){
                return rent;
            }
        }
        return null;
    }

    public void setCarRentFlag(int prodID){
        for (Car car : cars){
            if (car.getId() == prodID){
                car.setRented(true);
            }
        }
    }

}
