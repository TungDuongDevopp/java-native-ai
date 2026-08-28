package practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevertElement {
    private final Deque<Integer> stackInteger = new ArrayDeque<>();

    public int[] revertArray(int[] arr){
      for(int i : arr){
          stackInteger.push(i);
      }
      int index = 0;
        while(!stackInteger.isEmpty()){
           arr[index] = stackInteger.pop();
           index++;
        }
        return arr;
    }

    public String reverseString(String s){
        String[] strings = s.split(" ");
       StringBuilder builder = new StringBuilder();
        for(int i = strings.length - 1; i >= 0; i--){
            if(i != 0 ){
                builder.append(strings[i]).append(" ");
            }
           else {
                builder.append(strings[i]);
            }
        }
       return builder.toString();

    }



    public static void main(String[] args) {
        RevertElement revertElement = new RevertElement();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(revertElement.revertArray(arr)));
        String hello = "Hello world by Duong";
        System.out.println(hello);
        System.out.println(revertElement.reverseString(hello));
    }
}
