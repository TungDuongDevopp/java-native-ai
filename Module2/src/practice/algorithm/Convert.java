package practice.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class Convert {

    private final Deque<Integer> stack = new ArrayDeque<>();


    public String convert(int num) {
        StringBuilder sb = new StringBuilder();

        while(num>0) {
            stack.push(num%2);
            num /=2;
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.convert(50));
    }
}
