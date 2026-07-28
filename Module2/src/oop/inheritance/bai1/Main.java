package oop.inheritance.bai1;

public class Main {
    public static void main(String[] args) {
        Animal[]  animals = {new Dog("Milu"),
                new Cat("Tom"),
                new Cat("Golden"),
                new Cat("Mimi"),
                new Dog("Lulu")};

        for(Animal animal: animals){
                animal.makeSound();
        }

    }

}
