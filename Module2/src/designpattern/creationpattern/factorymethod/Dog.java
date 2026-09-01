package designpattern.creationpattern.factorymethod;


public class Dog implements IAnimal {
    @Override
    public void makeSound() {
        System.out.println("woof woof woof woof");
    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }


}
