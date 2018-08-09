package services;

import exceptions.AuthenticationError;
import exceptions.CarAlreadyExistsException;
import model.Car;
import model.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Map;

public class CarServiceProxy implements ICarService{
    private boolean isLoggedIn = false;
    // private boolean isUser; // Allow delete and edit only to users who created Car object
    private CarService carService;

    public CarServiceProxy(HttpServletRequest req){
        if( req.getSession().getAttribute("userName") != null) isLoggedIn = true;
        carService = CarService.INSTANCE;
    }

    @Override
    public Car createCar(Map<String, String> carDict, User user) throws CarAlreadyExistsException, ParseException, AuthenticationError {
        if(isLoggedIn){
            return carService.createCar(carDict,user);
        }else {
            throw new AuthenticationError("User Not Logged In");
        }
    }
}
