package Middle;

import java.util.Deque;
import java.util.LinkedList;

public class Solution394 {
    public String decodeString(String s) {
        Deque<String> strStk = new LinkedList<>();
        Deque<Integer> numStk = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= '9' && input[i] >= '0') {
                multi = multi * 10 + (input[i] - '0');
            } else if (input[i] == '[') {
                strStk.push(res.toString());
                res = new StringBuilder();
                numStk.push(multi);
                multi = 0;
            } else if (input[i] == ']') {
                StringBuilder tmp = new StringBuilder(strStk.pop());
                int times = numStk.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(res);
                }
                res = tmp;
            } else {
                res.append(String.valueOf(input[i]));
            }
        }
        return res.toString();
    }
}
