package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution316 {
    public String removeDuplicateLetters(String s) {
        int SIZE = 26;
        int len = s.length();
        boolean[] inqueue = new boolean[SIZE];
        int[] num = new int[SIZE];
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            num[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!inqueue[c - 'a']) {
                while (!deque.isEmpty() && num[deque.peekLast() - 'a'] > 0
                        && c < deque.peekLast()) {
                    inqueue[deque.peekLast() - 'a'] = false;
                    deque.removeLast();
                }
                inqueue[c - 'a'] = true;
                deque.addLast(c);
            }
            num[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("bcabc"));
    }
}