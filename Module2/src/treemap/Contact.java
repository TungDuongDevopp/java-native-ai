package treemap;

import utils.Validation;

import java.util.HashMap;
import java.util.Map;

public class Contact {

    private final Map<String,String> contact;

    public Contact(Map<String,String> contact) {
        this.contact = contact;
    }

    public void printContact(){
        System.out.println("Contact:");
        for(String s : contact.keySet()){
            System.out.println(s + " " + contact.get(s));
        }
    }
    public void addContact(String name, String phone){
        contact.put(name,phone);
    }
    public String getPhone(String name){
        if(!contact.containsKey(name)){
            return null;
        }
        return contact.get(name);
    }
    public void delContact(String name){
        contact.remove(name);
    }

    public static void main(String[] args) {
        Map<String,String> contact = new HashMap<>();
        contact.put("Dương","0345796153");
        contact.put("Mai","0978794415");
        contact.put("Huấn","0978794415");
        contact.put("Nụ","0358498723");
        contact.put("Khánh","0735876512");
        System.out.println("""
                1. In danh bạ
                2. Thêm danh bạ    \s
                3.Tìm kiếm danh bạ    \s
                4.Xóa danh bạ""");
        int choice = Validation.getValidInt("Mời nhập lua chọn: ",0,4);
        Contact contact1 = new Contact(contact);
        switch (choice){
            case 1:
                contact1.printContact();
                break;
            case 2:
                String name = Validation.getValidString("Mời nhập tên: ");
                String phone = Validation.getValidString("Mời nhập số điện thoại: ");
                contact1.addContact(name,phone);
                contact1.printContact();
                break;
            case 3:
                String nameSearch = Validation.getValidString("Mời nhập tên can tra cứu: ");
                System.out.println(contact1.getPhone(nameSearch));

                break;
            case 4:
                String nameDel = Validation.getValidString("Mời nhập tên xóa: ");
                contact1.delContact(nameDel);
                contact1.printContact();
                break;
            case 0:
                System.out.println("Bạn đã thoát");
                break;
        }


    }
}
