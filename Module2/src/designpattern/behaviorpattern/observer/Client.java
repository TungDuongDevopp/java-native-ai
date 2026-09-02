package designpattern.behaviorpattern.observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();

        IObserver observer1 = new IObserver() {
            public void update(String message) {
                System.out.println("Message 1 changed: " + message);
            }
        };

        subject.attach(observer1);

        IObserver observer2 = new IObserver() {
            public void update(String message) {
                System.out.println("Message 2 changed: " + message);
            }
        };

        subject.attach(observer2);

        subject.notifyChange("Test change state 1");

        subject.detach(observer1);

        subject.notifyChange("Test change state 2");
    }
}

