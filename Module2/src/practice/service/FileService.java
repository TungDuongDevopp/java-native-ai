package practice.service;

import practice.model.Product;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FILE_PATH ="D:\\java-native-ai\\Module2\\src\\resource\\product.txt";
   private void saveAll(List<Product> products) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             Files.newOutputStream(Path.of(FILE_PATH)))) {

            oos.writeObject(products);
        }
    }

    public void add(Product product) throws IOException {
        Path file = Path.of(FILE_PATH);

        List<Product> products;

        if (Files.exists(file) && Files.size(file) > 0) {
            products = readAll();
        } else {
            products = new ArrayList<>();
        }
        boolean exists = products.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(product.getName()));

        if (exists) {
            throw new IllegalArgumentException("Product already exists");
        }

        products.add(product);

        saveAll(products);
    }


    @SuppressWarnings("unchecked")
    public List<Product> readAll() throws IOException {
        Path file = Path.of(FILE_PATH);

        if (!Files.exists(file)) {
            throw new FileNotFoundException("File not found");
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(file))) {

            return (List<Product>) ois.readObject();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Product readByName(String name) throws IOException {
        List<Product> products = readAll();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        FileService fs = new FileService();

       fs.add(new Product("Test1", new BigDecimal("123456789"),"Sản phẩm test","Duong"));

       Product findProduct = fs.readByName("Test");
       System.out.println(findProduct);
//        List<Product> products2 = fs.readAll();
//        for (Product product : products2) {
//            System.out.println(product);
//        }
    }


}
