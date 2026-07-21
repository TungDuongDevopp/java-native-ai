package oop.basics;

import utils.Validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Student {
    private String name;
    private int age;
    private double[] scores;

    public Student(String name, int age, double[] scores) {
        setName(name);
        setAge(age);
        setScores(scores);
    }
    public Student(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(!Validation.isValidDouble(age,0,100,true)){
            throw new IllegalArgumentException("Tuổi không hợp lệ");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validation.isValidString(name)){
            throw new IllegalArgumentException("Tên không hợp lệ");
        }
        this.name = name;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores.clone();
    }
    public double getGPA(){
        int sum = 0;
        for(double score : scores){
            sum+=score;
        }
        double result = (double) sum / scores.length;

        return BigDecimal.valueOf(result)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", scores=" + Arrays.toString(scores) +
                ", GPA=" + getGPA() +
                '}';
    }
    public boolean isGreaterThan(Student y){
        return  getGPA() > y.getGPA();
    }

    public static void main(String[] args) {
        // Khởi tạo sinh viên
        Student st1 = new Student("Dương",22,new double[]{9,8,7,7.6,8.2,8.1,7.5});
        Student st2 = new Student("Linh",20,new double[]{9,8,7,7.6,8.1,6.2,7.5});

        // In thông tin sinh viên
        System.out.println(st1);
        System.out.println(st2);

        System.out.format("\nĐiểm của sinh viên 1: %.1f",st1.getGPA());
        System.out.format("\nĐiểm của sinh viên 1: %.1f",st2.getGPA());

        //In thông tin sinh viên có điểm cao hơn
        System.out.println("\nSinh viên có điểm cao hơn: ");
        if(st1.isGreaterThan(st2)){
            System.out.println(st1);
        }
        else {
            System.out.println(st2);
        }

    }
}
