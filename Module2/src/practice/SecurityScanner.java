package practice;

public class SecurityScanner {
    public static void main(String[] args) {
        String[] users = {"USER_01", null, "BANNED_01", "USER_02", "ADMIN_01", "USER_03", "USER_04"};
        int[] loginAttempts = {1, 0, 8, 4, 0, 5, 2};
        boolean[] isLocked = {false, false, true, false, false, false, false};

        boolean foundAdmin = false; // Đổi tên cho rõ nghĩa (Đã tìm thấy admin chưa)

        System.out.println("--- BẮT ĐẦU QUÉT HỆ THỐNG ---");
        long startTime = System.nanoTime();

        for (int i = 0; i < users.length; i++) {
            // 1. Loại bỏ các trường hợp không cần quét (Guard Clauses)
            if (users[i] == null || isLocked[i] || users[i].startsWith("BANNED_")) {
                continue;
            }

            // 2. MỤC TIÊU 1: Báo động đăng nhập sai > 3 lần (Áp dụng cho TẤT CẢ user hợp lệ, kể cả Admin)
            if (loginAttempts[i] > 3) {
                System.out.format("\nCảnh báo: User = %s đăng nhập sai %d lần!", users[i], loginAttempts[i]);
            }

            // 3. MỤC TIÊU 2: Tìm ADMIN đầu tiên (Chỉ xử lý nếu TRƯỚC ĐÓ CHƯA TÌM THẤY)
            if (!foundAdmin && users[i].startsWith("ADMIN_")) {
                System.out.format("\nĐã tìm thấy admin đầu tiên để gửi báo cáo: User = %s", users[i]);
                foundAdmin = true;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("\n\nThời gian quét: " + (endTime - startTime) + " nano giây.");
    }
}


