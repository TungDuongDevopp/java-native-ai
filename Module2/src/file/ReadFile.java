package file;

import practice.model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadFile {

    public void readFileText(String filePath) {
        try{
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file: " + filePath);
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                if(line.isBlank()) continue;
                line = line.trim();
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public void readFileTextByFiles(String filePath) {
        Path path = Path.of(filePath);

        try {
            if (!Files.exists(path)) {
                throw new IOException("Cannot find file: " + filePath);
            }

            int max = -Integer.MAX_VALUE;

            for (String line : Files.readAllLines(path)) {
                if (line.isBlank()) {
                    continue;
                }
                line = line.trim();
                System.out.println(line);
                int num = Integer.parseInt(line);
                if(max < num) {
                    max = num;
                }
            }
            writeFileTextByFiles(filePath, max);

            System.out.println("Giá trị lớn nhất là = " + max);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Đọc file thất bại: " + e.getMessage());
        }

    }

    private void writeFileTextByFiles(String filePath,int value) {
        Path path = Path.of(filePath);
        try{
            if (!Files.exists(path)) {
                throw new IOException("Cannot find file: " + filePath);
            }
            Files.writeString(path, String.valueOf(value),StandardOpenOption.CREATE,StandardOpenOption.APPEND);

        }
        catch (IOException | NumberFormatException e){
            System.err.println("Đọc file thất bại: " + e.getMessage());
        }

    }

    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Đọc file thất bại: " + e.getMessage());
        }
    }

    public void writeFileByObject(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            Student student = new Student("Duong", 9.1, "MALE");
            oos.writeObject(student);
            oos.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Success!");
    }

    public void readFileByObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Student student = (Student) ois.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        ReadFile example = new ReadFile();
//        example.readFileText("D:\\java-native-ai\\Module2\\src\\resource\\numbers.txt");
//        example.readFileTextByFiles("D:\\java-native-ai\\Module2\\src\\resource\\numbers.txt");

        example.writeFileByObject("D:\\java-native-ai\\Module2\\src\\resource\\object.txt");
        example.readFileByObject("D:\\java-native-ai\\Module2\\src\\resource\\object.txt");

    }
}
