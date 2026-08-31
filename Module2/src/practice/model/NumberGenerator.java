package practice.model;

import java.util.Random;

public class NumberGenerator  implements Runnable {
    private final Random rand = new Random();
    @Override
    public void run() {

       for(int i = 0; i < 10; i++) {
           try {
               System.out.println(Thread.currentThread().getName() + " is running");
               Thread.sleep(500);
           } catch (InterruptedException e) {
               System.err.println("InterruptedException");
           }
           Integer randNum = rand.nextInt(10);
           System.out.println(randNum);
           System.out.println(randNum.hashCode());
       }
    }

    public static void main(String[] args) throws InterruptedException {
        NumberGenerator generator = new NumberGenerator();
        Thread t1 = new Thread(generator);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t1.join();
        Thread t2 = new Thread(generator);
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();

        Thread t3 = new Thread(generator);
        t3.setPriority(6);
        t3.start();
    }
}
