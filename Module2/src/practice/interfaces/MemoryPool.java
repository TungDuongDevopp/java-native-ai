package practice.interfaces;

import java.util.LinkedList;

public  abstract class MemoryPool<T> {
    private final LinkedList<T> free_items = new LinkedList<>();

    public void freeItem(T item) {
        free_items.add(item);
    }

    protected abstract T allocate();

    public T newItem() {
        T out;
        if (free_items.isEmpty()) {
            out = allocate();
        } else {
            out = free_items.getFirst();
            free_items.removeFirst();
        }
        return out;
    }
}
