package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution402 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && deque.peekLast() > c && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        while (k-- > 0) {
            deque.removeLast();
        }
        if (deque.isEmpty()) {
            deque.addLast('0');
        }
        while (deque.size() > 1 && deque.peekFirst() == '0') {
            deque.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
