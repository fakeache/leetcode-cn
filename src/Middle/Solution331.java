package Middle;

import java.util.Deque;
import java.util.LinkedList;

public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        String[] input = preorder.split(",");
        Deque<Integer> stk = new LinkedList<>();
        stk.addLast(1);
        for (int i = 0; i < input.length; i++) {
            if (stk.isEmpty()) {
                return false;
            }
            int top = stk.removeLast();
            if (top == 2) {
                stk.addLast(1);
            }
            if (!"#".equals(input[i])) {
                stk.addLast(2);
            }
        }
        return stk.isEmpty();
    }
}
