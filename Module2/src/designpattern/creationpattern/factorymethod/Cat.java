package designpattern.creationpattern.factorymethod;

public class Cat  implements IAnimal{
    @Override
    public void makeSound() {
        System.out.println("meow meow");
    }

    @Override
    public void eat() {
        System.out.println("Cat eat");
    }
}
