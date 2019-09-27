package Simple;

import java.util.HashMap;

public class Solution242 {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char d = t.charAt(i);
            if (map.containsKey(d)) {
                if (map.get(d) == 1) {
                    map.remove(d);
                }
                else {
                    map.put(d, map.get(d) - 1);
                }
            }
            else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args){
        String s = "aafnasi";
        String t = "afnsiaa";
        System.out.println(isAnagram(s, t));
    }
}
