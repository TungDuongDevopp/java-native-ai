package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {
    public static void main(String[] args) {
        // Cấu hình số lượng phần tử ban đầu và số lần chèn
        final int INITIAL_ELEMENTS = 10_000;
        final int INSERT_COUNT = 1_000;

        // 1. Khởi tạo danh sách và thêm 10,000 phần tử ban đầu
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < INITIAL_ELEMENTS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("--- BẮT ĐẦU ĐO HIỆU NĂNG THÊM VÀO ĐẦU DANH SÁCH ---");
        System.out.println("Kích thước ban đầu của mỗi danh sách: " + INITIAL_ELEMENTS);
        System.out.println("Số lần thực hiện hành động add(0, x): " + INSERT_COUNT);
        System.out.println("-------------------------------------------------");

        // 2. Đo thời gian thực hiện trên ArrayList
        long startTimeArrayList = System.nanoTime();
        for (int i = 0; i < INSERT_COUNT; i++) {
            arrayList.addFirst(i); // Thêm phần tử 'i' vào vị trí số 0 (đầu danh sách)
        }
        long endTimeArrayList = System.nanoTime();
        long durationArrayList = endTimeArrayList - startTimeArrayList;

        // 3. Đo thời gian thực hiện trên LinkedList
        long startTimeLinkedList = System.nanoTime();
        for (int i = 0; i < INSERT_COUNT; i++) {
            linkedList.addFirst(i); // Thêm phần tử 'i' vào vị trí số 0 (đầu danh sách)
        }
        long endTimeLinkedList = System.nanoTime();
        long durationLinkedList = endTimeLinkedList - startTimeLinkedList;

        // 4. In kết quả đo đạc (Đổi từ nanoseconds sang milliseconds để dễ nhìn)
        System.out.printf("Thời gian ArrayList:  %,15d ns (~ %.3f ms)%n",
                durationArrayList, durationArrayList / 1_000_000.0);
        System.out.printf("Thời gian LinkedList: %,15d ns (~ %.3f ms)%n",
                durationLinkedList, durationLinkedList / 1_000_000.0);
        System.out.println("-------------------------------------------------");

        // 5. In kết luận so sánh hiệu năng
        if (durationArrayList > durationLinkedList) {
            double ratio = (double) durationArrayList / durationLinkedList;
            System.out.printf("👉 KẾT LUẬN: LinkedList nhanh hơn ArrayList khoảng %.1f lần khi thêm vào đầu.%n", ratio);
        } else {
            double ratio = (double) durationLinkedList / durationArrayList;
            System.out.printf("👉 KẾT LUẬN: ArrayList nhanh hơn LinkedList khoảng %.1f lần.%n", ratio);
        }
    }
}
