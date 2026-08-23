package stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bai1 {
    private static boolean isValidString(String str) {
        // Khởi tạo một Stack để lưu trữ các dấu ngoặc mở
        Deque<Character> stack = new ArrayDeque<>();

        // Duyệt qua từng ký tự trong chuỗi
        for (char c : str.toCharArray()) {
            // Nếu là dấu ngoặc mở, đẩy vào Stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Nếu là dấu ngoặc đóng
            else if (c == ')' || c == ']' || c == '}') {
                // Nếu Stack rỗng nghĩa là có ngoặc đóng mà không có ngoặc mở trước đó
                if (stack.isEmpty()) {
                    return false;
                }

                // Lấy dấu ngoặc mở gần nhất ra để so sánh
                char openBracket = stack.pop();

                // Kiểm tra xem dấu ngoặc mở và đóng có khớp cặp với nhau không
                if (c == ')' && openBracket != '(') return false;
                if (c == ']' && openBracket != '[') return false;
                if (c == '}' && openBracket != '{') return false;
            }

        }
        return stack.isEmpty();

    }
    public static void main(String[] args) {
        // Khởi tạo mảng chứa 4 test case (2 true, 2 false)
        String[] testCases = {
                "()[]{}",  // Case 1: Đúng (Xen kẽ hợp lệ)
                "{[()]}",  // Case 2: Đúng (Lồng nhau hợp lệ)
                "([)]",    // Case 3: Sai (Sai thứ tự đóng mở)
                "(([]{}"   // Case 4: Sai (Dư dấu ngoặc mở)
        };

        System.out.println("--- KẾT QUẢ KIỂM TRA CHUỖI DẤU NGOẶC ---");

        for (int i = 0; i < testCases.length; i++) {
            String currentCase = testCases[i];
            boolean result = isValidString(currentCase);

            // Định dạng chuỗi in ra kết quả cho trực quan
            String status = result ? "✅ HỢP LỆ (True)" : "❌ KHÔNG HỢP LỆ (False)";
            System.out.printf("Case %d: %-10s -> %s%n", (i + 1), "\"" + currentCase + "\"", status);
        }
    }
}
