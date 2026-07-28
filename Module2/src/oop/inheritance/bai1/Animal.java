package oop.inheritance.bai1;

import utils.Validation;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        setName(name);
    }
    public void makeSound(){
       System.out.println("Animal is making a sound");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!Validation.isValidString(name)){
            throw new IllegalArgumentException("Name không được để trống!");
        }
        this.name = name;
    }
}
