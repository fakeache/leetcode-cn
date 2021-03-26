package Middle;

import java.util.Deque;
import java.util.LinkedList;

class Solution227 {
    public int calculate(String s) {
        Deque<Integer> nstk = new LinkedList<>();
        int len = s.length();
        int num = 0;
        char prec = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                switch(prec) {
                    case '+':
                        nstk.addLast(num);
                        break;
                    case '-':
                        nstk.addLast(-num);
                        break;
                    case '*':
                        nstk.addLast(nstk.removeLast() * num);
                        break;
                    default:
                        nstk.addLast(nstk.removeLast() / num);
                }
                prec = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!nstk.isEmpty()) {
            ans += nstk.removeLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution227().calculate("3+2"));
    }
}
