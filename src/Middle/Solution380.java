package Middle;

import java.util.*;

public class Solution380 {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public Solution380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random(47);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int size = list.size();
        int last = list.get(size - 1);
        list.set(idx, last);
        map.put(last, idx);
        list.remove(size - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
