package sort;

public class InsertionSort {
    private final int[] array;
    public InsertionSort(int[] array) {
        this.array = array;
    }
    public void print(){
        System.out.println();
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    public void sort(){
        int countSwap = 0;
        int countCompare = 0;
        for (int i = 1; i < array.length; i++) {
            int key =  array[i];
            int j = i - 1;
            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                countSwap++;
                countCompare++;
                j--;
            }
            array[j+1] = key;
        }
        System.out.println("Số lần so sánh là: "+ countCompare);
        System.out.println("Số lần đổi chỗ là: "+ countSwap);
    }
    public static void main(String[] args) {
        InsertionSort insertionSort= new InsertionSort(new int[]{1,4,3,6,23,3,12,1,7,0,9,16});
        InsertionSort insertionSort2= new InsertionSort(new int[]{0,1,1,3,3,4,6,7,9,12,16,23});
        InsertionSort insertionSort3= new InsertionSort(new int[]{23,16,12,9,7,6,4,3,3,1,1,0});
        insertionSort.print();
        insertionSort.sort();
        insertionSort.print();

        insertionSort2.print();
        insertionSort2.sort();
        insertionSort2.print();

        insertionSort3.print();
        insertionSort3.sort();
        insertionSort3.print();
    }
}
