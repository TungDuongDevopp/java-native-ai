package designpattern.behaviorpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Subject {
    private final List<IObserver> observers = new ArrayList<>();

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyChange(String message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }


}
