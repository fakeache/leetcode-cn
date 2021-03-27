package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution241 {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> rs = new ArrayList<>();
        if (expression == null || expression.length() == 0) {
            return rs;
        }
        int num = 0;
        int len = expression.length();
        int i = 0;
        for (; i < len; i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            num = num * 10 + c - '0';
        }
        if (i == len) {
            rs.add(num);
            return rs;
        }
        for (; i < len; i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        rs.add(cal(c, left.get(j), right.get(k)));
                    }
                }
            }
        }
        return rs;
    }

    public int cal(char c, int x, int y) {
        switch(c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            default:
                return x * y;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution241().diffWaysToCompute("2-1"));
    }
}