package designpattern.behaviorpattern.strategy;

import java.util.List;

public interface ISortStrategy {
    <T> void sort(List<T> items);
}
