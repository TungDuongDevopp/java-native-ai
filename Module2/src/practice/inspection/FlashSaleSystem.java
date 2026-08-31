package practice.inspection;

    public class FlashSaleSystem {

        // --- MODULE 1: BÁN HÀNG (RACE CONDITION) ---
        private int stock = 100; // Tồn kho 100 chiếc

        public synchronized void buyIphone() {
            if (stock > 0) {
                try {
                    // Giả lập độ trễ khi kết nối Database
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }

                stock--;
                System.out.println(Thread.currentThread().getName() + " mua thành công. Kho còn: " + stock);
            }
        }

        // --- MODULE 2: ĐỔI QUÀ (DEADLOCK) ---
        static class VIPUser {
            String name;
            public VIPUser(String name) { this.name = name; }
        }

        public void swapGifts(VIPUser userA, VIPUser userB) {
            synchronized (userA) {
                System.out.println(Thread.currentThread().getName() + " đã khóa " + userA.name);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }

                System.out.println(Thread.currentThread().getName() + " đang chờ khóa " + userB.name + "...");
                synchronized (userB) {
                    System.out.println("Đổi quà thành công giữa " + userA.name + " và " + userB.name);
                }
            }
        }

        public static void main(String[] args) {
            FlashSaleSystem system = new FlashSaleSystem();

            // 1. Gây bão Race Condition (1000 người cùng tranh 100 cái đt)
            for (int i = 0; i < 1000; i++) {
                new Thread(system::buyIphone).start();
            }

            // 2. Gây sập hệ thống bằng Deadlock
            VIPUser alice = new VIPUser("Alice");
            VIPUser bob = new VIPUser("Bob");

            // Luồng 1: Alice đổi quà với Bob
            new Thread(() -> system.swapGifts(alice, bob), "Luồng-Alice").start();
//            // Luồng 2: Bob đổi quà với Alice
//            new Thread(() -> system.swapGifts(bob, alice), "Luồng-Bob").start();
        }
    }

