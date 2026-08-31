package practice.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;

    private double score;

    private String gender;

    public Student(String name, double score, String gender) {
        setName(name);
        setScore(score);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name== null || name.isBlank()){
            throw new IllegalArgumentException("Invalid gender");
        }
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if(score < 0 || score >10){
            throw new IllegalArgumentException("Invalid score");
        }
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender == null || gender.isBlank()){
            throw new IllegalArgumentException("Invalid gender");
        }
        this.gender = gender;
    }

    public void study(){
        System.out.println("Student " + this.name + " is studying " + this.score);
    }
    public void playing() {

        System.out.printf("Student %s with gender %s is playing%n", this.name, this.gender);
    }

    @Override
    public String toString(){
        return String.format("Student %s with score %.1f", this.name, this.score);
    }

    public static void main(String[] args) {
        Student s1 = new Student("John", 9.5, "MALE");
        Student s2 = new Student("Mary", 7.2, "FEMALE");
        Student s3 = new Student("Duong", 10, "MALE");
        s1.study();
        s1.playing();
        s2.study();
        s2.playing();
        s3.study();
        s3.playing();
    }
}
