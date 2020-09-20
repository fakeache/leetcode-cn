package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        char[] rs = new char[len];
        int bal = 0;
        if (numRows == 1) {
            bal = 1;
        } else {
            bal = 2 * numRows - 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            while (bal * j + i < len) {
                if (i == 0 || i == numRows -1) {
                    sb.append(s.charAt(i + bal * (j++)));
                } else {
                    sb.append(s.charAt(i + bal * (j)));
                    if (bal * j + bal - i < len) {
                        sb.append(s.charAt(bal * j + bal - i));
                    }
                    j++;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 答案里更好的解法，逻辑更简单
     */
    public String convert1(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int circleLen = 2 * numRows - 2;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < len; i++) {
            int r = i % circleLen;
            if (r > numRows - 1) {
                r = circleLen - r;
            }
            list.get(r).append(s.charAt(i));
        }
        StringBuilder sb = list.get(0);
        for (int i = 1; i < numRows; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        s.convert("ABC", 2);
    }
}