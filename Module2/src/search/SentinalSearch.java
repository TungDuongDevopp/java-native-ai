package search;

public class SentinalSearch {
    private final int[] array;
    private final int k;
    public SentinalSearch(int[] array, int k) {
        this.array = array;
        this.k = k;
    }

    public int search() {
        int[] arr = new int[array.length + 1];
        System.arraycopy(array, 0, arr, 0, array.length);
        arr[arr.length - 1] = k;

        int count = 0;
        int i = 0;
        while (arr[i] != k) {
            count++;
            i++;
        }

        if (i < arr.length - 1) {
            System.out.println("Số lần thực hiện là: "+ count);
            return i;
        }
        System.out.println("không tìm thấy phần tử");
        System.out.println("Số lần thực hiện là: "+ count);
        return -1;
    }

    public static void main(String[] args) {
        SentinalSearch sentinalSearch = new SentinalSearch(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20},17);
       System.out.println("Sentinal search: " + sentinalSearch.search());
    }
}
