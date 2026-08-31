package practice.inspection;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RobotControlSystem {

    private int totalWeight = 0;

    public synchronized void dropItem() {
        try { Thread.sleep(5); } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        totalWeight += 10;
    }

    public int getTotalWeight() { return totalWeight; }

    static class Zone {
        private static final AtomicInteger idGenerator = new AtomicInteger(0);

        final int id;
        final String name;
        final ReentrantLock lock = new ReentrantLock();

        public Zone(String name) {
            this.name = name;
            this.id = idGenerator.getAndIncrement(); // Tự động tăng ID khi tạo mới
        }
    }


    public void moveRobot(Zone currentZone, Zone nextZone, String robotName) {
        // 1. Luôn ưu tiên chiếm khóa của Zone có ID nhỏ hơn trước
        Zone firstLock = currentZone.id < nextZone.id ? currentZone : nextZone;
        Zone secondLock = firstLock == currentZone ? nextZone : currentZone;

        while (true) {
            try {
                // 2. Thử chiếm khóa đầu tiên
                if (firstLock.lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                    try {
                        // 3. Thử chiếm khóa thứ hai
                        if (secondLock.lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println(robotName + " di chuyển từ " + currentZone.name + " sang " + nextZone.name);

                                // Giả lập thời gian robot di chuyển qua khu vực mới
                                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200));
                                return; // Thành công -> Thoát hàm
                            } finally {
                                secondLock.lock.unlock();
                            }
                        }
                    } finally {
                        firstLock.lock.unlock();
                    }
                }

                // 4. Backoff: Nghỉ ngẫu nhiên một chút trước khi thử lại để nhường luồng khác
                Thread.sleep(ThreadLocalRandom.current().nextInt(10, 50));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        RobotControlSystem system = new RobotControlSystem();

        // 1. Gây bão Race Condition (500 robot cùng thả hàng)
        Thread[] robots = new Thread[500];
        for (int i = 0; i < 500; i++) {
            robots[i] = new Thread(system::dropItem);
            robots[i].start();
        }
        for (Thread r : robots) r.join(); // Đợi tất cả thả xong
        System.out.println("Kỳ vọng: 5000 kg. Thực tế trạm cân ghi nhận: " + system.getTotalWeight() + " kg");

        // 2. Gây treo hệ thống (Deadlock)
        System.out.println("\n--- Bắt đầu mô phỏng ngã tư ---");
        Zone zoneA = new Zone("Khu A");
        Zone zoneB = new Zone("Khu B");

        Thread robot1 = new Thread(() -> system.moveRobot(zoneA, zoneB, "Robot-Alpha"));
        Thread robot2 = new Thread(() -> system.moveRobot(zoneB, zoneA, "Robot-Beta"));

        robot1.start();
        robot2.start();

        System.out.println("Hệ thống đứng hình, không bao giờ tới được dòng lệnh này...");
    }
}

