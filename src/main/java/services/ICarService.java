package services;

import exceptions.AuthenticationError;
import exceptions.CarAlreadyExistsException;
import model.Car;
import model.User;

import java.text.ParseException;
import java.util.Map;

public interface ICarService {

    public Car createCar(Map<String, String> carDict, User user) throws CarAlreadyExistsException, ParseException, AuthenticationError;
}
