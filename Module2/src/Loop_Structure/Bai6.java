package Loop_Structure;

import java.util.Arrays;

public class Bai6 {
    public static void main(String[] args) {
        int[] scores = {8, 7, 9, 6, 10};
        int sum = 0;
        for (int score: scores){
            sum+=score;
        }
        System.out.format("Tổng điểm của mảng %s là: %d", Arrays.toString(scores),sum);
        System.out.format("\nĐiểm trung bình của mảng %s là: %d",Arrays.toString(scores),(double)sum/scores.length);
    }
}
