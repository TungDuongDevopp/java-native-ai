package datastructure;

import utils.Validation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
                new Student("Nga", 4.9)
        ));
        Student.getStudents(students);
        Student studentWithMaxScore = findStudentWithMaxScore(students);
        if (studentWithMaxScore != null) {
            System.out.println("Sinh viên có điểm cao nhất là: " + studentWithMaxScore);

        }

        Student studentWithMinScore = findStudentWithMinScore(students);
        if (studentWithMinScore != null) {
            System.out.println("Sinh viên có điểm thâp nhất là: " + studentWithMinScore);
        }
        List<Student> studentsWithScores = removeStudentsWithScore(students, 5);
        if (!studentsWithScores.isEmpty()) {
            System.out.println(studentsWithScores.size());
            for (Student student : studentsWithScores) {
                System.out.println(student);
            }
        }

    }
}

