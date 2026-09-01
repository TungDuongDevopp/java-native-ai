package designpattern.creationpattern.factorymethod;

public class FactoryAnimal {
    public IAnimal getAnimal(String animalType) {
       if (animalType.equals("cat")) {
           return new Cat();
       }
        if (animalType.equals("dog")) {
           return new Dog();
       }
        throw new IllegalArgumentException("Unknown animal");
    }

    public static void main(String[] args) {
        FactoryAnimal animal = new FactoryAnimal();
        IAnimal cat = animal.getAnimal("cat");
        if (cat instanceof Cat) {
            cat.eat();
            cat.makeSound();
        }
        IAnimal dog = animal.getAnimal("dog");
        if (dog instanceof Dog) {
            dog.eat();
            dog.makeSound();
        }
    }
}
