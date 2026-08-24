package search;

public class LinearSearch {

    private final int k;
    private final int [] array;
    public LinearSearch(int k, int [] array) {
        this.k = k;
        this.array = array;
    }


    public int search(){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            count++;
            if(array[i]==k){
                System.out.println("Số lần thực hiện: " + count);
                return i;
            }
        }


        System.out.println("Số lần thực hiện: " + count);
        System.out.println("Không tìm thấy phân tử");
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch search = new LinearSearch(11,new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(search.search());
    }
}
