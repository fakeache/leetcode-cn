package Middle;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Set<String> set = new HashSet<String>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        for (String token : tokens) {
            if (set.contains(token)) {
                Integer a2 = stack.pop();
                Integer a1 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(a1 + a2);
                } else if ("-".equals(token)) {
                    stack.push(a1 - a2);
                } else if ("*".equals(token)) {
                    stack.push(a1 * a2);
                } else if ("/".equals(token)) {
                    stack.push(a1 / a2);
                }
            } else {
                int flag = 1;
                int value = 0;
                for (int i = 0; i < token.length(); i++) {
                    if (i == 0 && (token.charAt(i) == '-' || token.charAt(i) == '+')) {
                        flag = token.charAt(i) == '-' ? -1 : 1;
                        continue;
                    }
                    value = value * 10 + token.charAt(i) - '0';
                }
                value = flag * value;
                stack.push(value);
            }
        }
        return stack.pop();
    }
}