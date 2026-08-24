package sort;

public class SelectionSort {
    private final int[] array;
    public SelectionSort(int[] array) {
        this.array = array;
    }


    public void sort(){
        int countCompare = 0;
        int countSwap = 0;
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    countCompare++;
                    min = j;
                }

            }
            countSwap++;
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

        }
        System.out.println("Số lần so sánh là: "+ countCompare);
        System.out.println("Số lần đổi chỗ là: "+ countSwap);
    }
    public void print(){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort(new int[]{1,4,3,6,23,3,12,1,7,0,9,16});
        selectionSort.print();
        selectionSort.sort();
        selectionSort.print();
    }
}
