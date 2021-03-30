package Middle;

import java.util.Iterator;

class Solution284 implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next;
    int flag = 0;

    public Solution284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) {
            return null;
        }
        if (flag == 0) {
            next = iterator.next();
            flag = 1;
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (flag == 0) {
            return iterator.next();
        } else {
            flag = 0;
            return next;
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || flag == 1;
    }
}
