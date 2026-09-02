package practice.model;

import practice.interfaces.IRandomNumberList;

import java.util.List;
import java.util.Random;

public class RandomNumberList implements IRandomNumberList {
    private final List<Integer> nums;

    private final Random random = new Random();
    private static final int DEFAULT_SIZE = 10;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public RandomNumberList(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public void printNumberList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    @Override
    public void generateRandomNumberList(Integer size, Integer min, Integer max) {

        if(size == null){
            size = DEFAULT_SIZE;
        }
        if(min == null){
            min = MIN_VALUE;
        }
        if(max == null){
            max = MAX_VALUE;
        }
        if(max<min){
            throw new IllegalArgumentException("max number must be greater than min");
        }
        for(int i = 0; i<size;i++){
            nums.add(random.nextInt(max - min + 1) + min);
        }
    }

    private List<Integer> filter(boolean isEven) {
        if (isEven) {
            return nums.stream().filter(num-> num % 2 == 0).toList();
        }
        return nums.stream().filter(num-> num % 2 != 0).toList();

    }

    @Override
    public List<Integer> getOddList() {
        return filter(false);
    }

    @Override
    public List<Integer> getEvenList() {
        return filter(true);
    }

}
