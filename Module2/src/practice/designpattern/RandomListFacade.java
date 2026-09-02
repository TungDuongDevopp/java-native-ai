package practice.designpattern;

import practice.model.RandomNumberList;

import java.util.ArrayList;

public class RandomListFacade {

    private final RandomNumberList randomNumberList =
            new RandomNumberList(new ArrayList<>());

    public void generate(Integer size, Integer min, Integer max) {
        randomNumberList.generateRandomNumberList(size, min, max);
    }

    public void printList() {
        System.out.print("Odd: ");
        randomNumberList.printNumberList(
                randomNumberList.getOddList()
        );

        System.out.println();

        System.out.print("Even: ");
        randomNumberList.printNumberList(
                randomNumberList.getEvenList()
        );
    }

    public static void main(String[] args) {
        RandomListFacade facade = new RandomListFacade();
        facade.generate(10, 10, 20);
        facade.printList();
    }
}
