package practice.inspection;

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    int price;
}
public class ProductBuilder {
    public static void main(String[] args) {
        // Yêu cầu: Tạo danh sách đối tượng sản phẩm từ mảng tên cho trước
        String[] productNames = {"Áo thun", "Mũ lưỡi trai", "Quần Jean"};
        List<Product> productList = new ArrayList<>();


        for (String productName : productNames) {
            Product tempProduct = new Product();
            tempProduct.name = productName;
            tempProduct.price = 100;

            // Thêm sản phẩm vào danh sách
            productList.add(tempProduct);
        }

        // In kết quả ra màn hình
        for (Product p : productList) {
            System.out.println("{ name: '" + p.name + "', price: " + p.price + " }");
        }
    }
}
