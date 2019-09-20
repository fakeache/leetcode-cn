package Simple;

import java.util.Stack;

public class Solution232 {

    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public Solution232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty()) {
            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(!empty()) {
            if (!stack2.empty()) {
                return stack2.peek();
            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
