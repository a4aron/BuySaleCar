package Command;

import Momento.CareTaker;
import Momento.Momento;
import model.Car;

import java.util.List;

public class BackupCommand implements Command{

    private CareTaker careTaker = new CareTaker();
    private Momento momento;

    @Override
    public void backup(List<Car> cars) {
        momento = new Momento(cars);
        careTaker.addMomento(momento);
    }

    @Override
    public Momento restore(){
        return careTaker.getMomento();
    }
}
