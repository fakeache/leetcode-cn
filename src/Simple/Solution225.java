package Simple;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {

    public Queue<Integer> q = new LinkedList();
    /** Initialize your data structure here. */
    public Solution225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while(size-- > 1) {
            q.add(q.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

