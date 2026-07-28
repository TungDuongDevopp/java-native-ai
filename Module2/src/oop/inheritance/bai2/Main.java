package oop.inheritance.bai2;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Dương",15000000);
        System.out.println(employee);

        Manager manager = new Manager("Vy",20000000,1000000);
        System.out.println(manager);

       Employee employee1 = new Manager("Ngân",15000000,1000000);

       if(employee1 instanceof Manager){
           Manager manager1 = (Manager) employee1;
          System.out.println(manager1.getBonus());
        }
       else {
           System.out.println("employee1 không phải manager1");
       }


    }
}
