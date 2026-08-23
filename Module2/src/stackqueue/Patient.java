package stackqueue;


import utils.Validation;

import java.util.*;

public class Patient {
    private static int idCounter = 0;
    private int id;
    private String name;
    private boolean priority;

    public Patient(String name, boolean priority) {
        setName(name);
        this.priority = priority;
        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validation.isValidString(name)){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>(List.of(
                new Patient("Nguyên", false), // id = 1
                new Patient("Hà", false),     // id = 2
                new Patient("Quang", true),   // id = 3
                new Patient("Huệ", false),    // id = 4
                new Patient("Nghĩa", false),  // id = 5
                new Patient("Tường", true))); // id = 6

        Deque<Patient> queue = new ArrayDeque<>(patients);
        System.out.println("--- Hàng đợi không ưu tiên ---");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Khai báo PriorityQueue siêu gọn gàng bằng Comparator chain
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(Patient::isPriority, Comparator.reverseOrder())
                        .thenComparing(Patient::getId)
        );

        System.out.println("--- Hàng đợi ưu tiên chuẩn tuyệt đối ---");
        priorityQueue.addAll(patients);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }


}
