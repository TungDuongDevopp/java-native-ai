package search;


public class BinarySearch {
    private final int k;
    private final int[] array;

    public BinarySearch(int k, int[] array) {
        this.k = k;
        this.array = array;
    }

    public int search() {
        int count = 0;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            count ++;
            int mid = (low + high) / 2;

            if (array[mid] == k) {
                System.out.println("Số lần thực hiện là: " + count);
                return mid;
            }
            else if (array[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println("Không tìm thấy phần tử");
        System.out.println("Số lần thực hiện là: "+ count);
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch(14,new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
        BinarySearch binarySearch = new BinarySearch(14, new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
        System.out.println("Binary search: "+ binarySearch.search());
        System.out.println("Linear search: "+ linearSearch.search());

    }
}
