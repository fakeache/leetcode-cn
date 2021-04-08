package Middle;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
interface NestedInteger {
 // @return true if this NestedInteger holds a single integer, rather than a nested list.
 public boolean isInteger();
 // @return the single integer that this NestedInteger holds, if it holds a single integer
 // Return null if this NestedInteger holds a nested list
 public Integer getInteger();
 // @return the nested list that this NestedInteger holds, if it holds a nested list
 // Return empty list if this NestedInteger holds a single integer
 public List<NestedInteger> getList();
}

public class Solution341 implements Iterator<Integer> {

    Deque<Integer> list = new LinkedList<>();

    public Solution341(List<NestedInteger> nestedList) {
        for (NestedInteger ele : nestedList) {
            dfs(ele);
        }
    }

    public void dfs(NestedInteger nin) {
        if (nin == null) {
            return;
        }
        if (nin.isInteger()) {
            list.add(nin.getInteger());
        } else {
            List<NestedInteger> nlist = nin.getList();
            for (NestedInteger nestedInteger : nlist) {
                dfs(nestedInteger);
            }
        }
    }
    @Override
    public Integer next() {
        return list.poll();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
