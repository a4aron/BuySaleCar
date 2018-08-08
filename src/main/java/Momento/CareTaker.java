package Momento;

import java.util.Stack;

public class CareTaker {
    private Stack<Momento> momentos = new Stack<Momento>();

    public Momento getMomento() {
        return momentos.pop();
    }

    public void addMomento(Momento momento) {
        momentos.push(momento);
    }
}
