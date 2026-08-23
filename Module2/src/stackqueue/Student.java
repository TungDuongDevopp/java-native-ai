package stackqueue;

import utils.Validation;

import java.util.*;

public class Student implements Comparable<Student>{
    private String name;

    private double score;

    public Student(String name, double score) {
        setName(name);
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validation.isValidString(name)) {
            throw new IllegalArgumentException("Student name is invalid");
        }
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (!Validation.isValidDouble(score, 0, Double.MAX_VALUE, false)) {
            throw new IllegalArgumentException("Student score is invalid");
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

    public static void getStudents(List<Student> students) {
        students.forEach(student -> System.out.println(student));
    }

    public static Student findStudentWithMaxScore(List<Student> students) {
        return students.stream().max(Comparator.comparingDouble(Student::getScore)).orElse(null);
    }

    public static Student findStudentWithMinScore(List<Student> students) {
        return students.stream().min(Comparator.comparingDouble(Student::getScore)).orElse(null);
    }
    public static List<Student> removeStudentsWithScore(List<Student> students, double score) {
        return students.stream().filter(student -> student.getScore()>score).toList();
    }
    @Override
    public int compareTo(Student o) {
        return Double.compare(this.score, o.score);
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Dương", 10.0),
                new Student("Mai", 9.7),
                new Student("Quyền", 6.5),
                new Student("Khải", 8.2),
                new Student("Vân", 4.5),
                new Student("Khánh", 8.0),
                new Student("Vy", 9),
                new Student("Nga", 4.9),
                new Student("Quân", 4.9)
        ));

        students.sort(Comparator.comparing(Student::getScore).thenComparing(Student::getName));
        Student.getStudents(students);

    }


}

