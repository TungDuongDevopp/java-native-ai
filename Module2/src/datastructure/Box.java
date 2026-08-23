package datastructure;

public class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(5);
        Box<String> stringBox = new Box<>("Hello World");
        Box<Student> studentBox = new Box<>(new Student("Dương",10));
        System.out.println(integerBox.getValue());
        System.out.println(stringBox.getValue());
        System.out.println(studentBox.getValue());
    }
}
