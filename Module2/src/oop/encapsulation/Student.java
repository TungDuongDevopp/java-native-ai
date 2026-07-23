package oop.encapsulation;

import utils.Validation;

public class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        setName(name);
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if(!Validation.isValidString(name)){
            throw new IllegalArgumentException("Name không hợp lệ");
        }
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if(!Validation.isValidDouble(score,0,10,false)){
            throw new IllegalArgumentException("Điểm phải nằm từ 0 -> 10");
        }
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
    public static void main(String[] args) {
        Student st1 = new Student("Dương",9.2);
        System.out.println("Thong tin sinh viên: ");
        System.out.println(st1);
        try{
            st1.setScore(-15);
            System.out.println("Thông tin sinh viên: ");
        }
        catch (IllegalArgumentException e){
            System.out.println("Điểm không hợp lệ!");
        }
    }

}


