package practice.model;

import java.util.Random;

public class Car implements Runnable {
    public static final int DISTANCE = 100;
    public static final int STEP = 5;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        int runDistance = 0;

        long startTime = System.currentTimeMillis();
        while (runDistance < DISTANCE) {
            try {
                StringBuilder logBuilder = new StringBuilder("|");
                int speed = (new Random()).nextInt(20);
                runDistance += speed;
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        logBuilder.append("=");
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        logBuilder.append("o");
                    } else {
                        logBuilder.append("-");
                    }
                }
                logBuilder.append("|");
                System.out.println("Car" + this.name + ": " + logBuilder + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100KM");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
