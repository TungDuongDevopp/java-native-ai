package oop.abstraction;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }
    public Shape(){}
    abstract double calculateArea();
    public void display(){
        System.out.println("Hình: " + name + ", diện tích: " + calculateArea());
    }

    @Override
    public String toString() {
        return String.format("Hình : %s, Diện tích : %.1f",name,calculateArea());
    }
}
