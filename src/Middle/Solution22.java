package Middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution22 {

    List<String> rslist = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return rslist;
        }
        addbracket(new StringBuilder(), new LinkedList<>(), n, 0);
        return rslist;
    }

    public void addbracket(StringBuilder sb, Deque<Character> stack, int n, int lnum) {
        int size = stack.size();
        int slen = sb.length();
        if (slen == 2 * n) {
            rslist.add(sb.toString());
            return;
        }
        if (lnum < n) {
            StringBuilder lsb = new StringBuilder(sb);
            lsb.append('(');
            Deque<Character> lstack = new LinkedList<>(stack);
            lstack.push('(');
            addbracket(lsb, lstack, n, lnum + 1);
        }
        if (!stack.isEmpty()) {
            StringBuilder rsb = new StringBuilder(sb);
            rsb.append(')');
            Deque<Character> rstack = new LinkedList<>(stack);
            rstack.pop();
            addbracket(rsb, rstack, n, lnum);
        }
    }
}
