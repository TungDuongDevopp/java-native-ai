package practice.interfaces;

import java.util.List;

public interface IRandomNumberList {
    void printNumberList(List<Integer> list);
    void generateRandomNumberList(Integer size, Integer min, Integer max);
    List<Integer> getOddList();
    List<Integer> getEvenList();
}
