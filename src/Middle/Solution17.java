package Middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution17 {
    List<String> rslist = new LinkedList<>();
    Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return rslist;
        }
        getAll(new StringBuilder(), digits, 0);
        return rslist;
    }

    public void getAll(StringBuilder sb, String digits, int i) {
        if (i > digits.length()) {
            return;
        }
        if (i == digits.length()) {
            rslist.add(sb.toString());
            return;
        }
        String alpha = map.get(digits.charAt(i) - '0');
        for (int j = 0; j < alpha.length(); j++) {
            StringBuilder nsb = new StringBuilder(sb);
            nsb.append(alpha.charAt(j));
            getAll(nsb, digits, i + 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        System.out.println(solution.letterCombinations("23"));
    }
}