package oop.basics;

import utils.Validation;

public class Rectangle {
    private int width,height;

    public Rectangle(){}

    public Rectangle(int height, int width) {
       setHeight(height);
       setWidth(width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(!Validation.isValidDouble(height,0,Integer.MAX_VALUE,true)){
            throw new IllegalArgumentException("Chiều cao không hợp lệ");
        }
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(!Validation.isValidDouble(width,0,Integer.MAX_VALUE,true)){
            throw new IllegalArgumentException("Chiều rộng không hợp lệ");
        }
        this.width = width;
    }

    public int area(){
        return width*height;
    }
    public int perimeter(){
        return (width+height)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle(4,8);

        // In thông tin hcn
        System.out.println("Thông tin hình chữ nhật ban đầu: ");
        System.out.println(rec);

        // Thực hiện in chu vi diện tích
        System.out.format("\nChu vi hình chữ nhật ban đầu là: %d",rec.perimeter());
        System.out.format("\nDiện tích hình chữ nhật  ban đầu là: %d",rec.area());

        // Thực hiện thay đổi chiều dài chiều rộng
        rec.setWidth(7);
        rec.setHeight(5);

        // In thông tin hcn
        System.out.println("\nThông tin hình chữ nhật sau khi thay đổi: ");
        System.out.println(rec);

        // Thực hiện in chu vi diện tích
        System.out.format("\nChu vi hình chữ nhật sau khi thay đổi là: %d",rec.perimeter());
        System.out.format("\nDiện tích hình chữ nhật sau khi thay đổi là: %d",rec.area());
    }
}
