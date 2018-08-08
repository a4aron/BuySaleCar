package Momento;

import model.Car;
import java.util.List;

public class Momento {
    private List<Car> cars;

    public Momento(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
