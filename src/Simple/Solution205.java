package Simple;

import java.util.HashMap;

public class Solution205 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            }
            else {
                if (map.containsValue(b)) {
                    return false;
                }
                else {
                    map.put(a, b);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "apple";
        String t = "dccag";
        System.out.println(isIsomorphic(s, t));
    }
}