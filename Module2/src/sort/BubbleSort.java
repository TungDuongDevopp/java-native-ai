package sort;

public class BubbleSort {
    private final int[] array;
    public BubbleSort(int[] array) {
        this.array = array;
    }
    public void print(){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    public void sort(){
        int countSwap = 0;
        int countCompare = 0;
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    countCompare++;
                    countSwap++;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(countSwap == 0) break;
        }
        System.out.println("Số lần so sánh là: "+ countCompare);
        System.out.println("Số lần đổi chỗ là: "+ countSwap);
    }
    public static void main(String[] args) {
        BubbleSort bubbleSort= new BubbleSort(new int[]{1,4,3,6,23,3,12,1,7,0,9,16});
        BubbleSort bubbleSort2= new BubbleSort(new int[]{0,1,1,3,3,4,6,7,9,12,16,23});
        bubbleSort.print();
        bubbleSort.sort();
        bubbleSort.print();

        bubbleSort2.print();
        bubbleSort2.sort();
        bubbleSort2.print();
    }
}
