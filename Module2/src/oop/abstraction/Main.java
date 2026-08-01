package oop.abstraction;

import java.util.ArrayList;
import java.util.List;
;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>(List.of(new Rectangle("HCN",4,5),
                new Circle("HT",4),
                new Circle("HT",6),
                new Circle("HT",5),
                new Rectangle("HCN",3,7),
                new Rectangle("HCN",4,6)));
        for (Shape shape : shapes){
            System.out.println(shape);
        }

        IPayable invoice = new Invoice(100000);
        IPayable employee = new Employee(8,15000);

        invoice.printReceipt();
        employee.printReceipt();
    }
}
