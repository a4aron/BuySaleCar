package Command;

import Momento.Momento;
import model.Car;

import java.util.List;

public interface Command {
    void backup(List<Car> cars);
    Momento restore();
}
