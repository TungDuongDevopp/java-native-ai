package designpattern.behaviorpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class SortedList {
    private ISortStrategy strategy;
    private final List<String> items = new ArrayList<>();

    public void setSortStrategy(ISortStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void sort() {
        strategy.sort(items);
    }
}
