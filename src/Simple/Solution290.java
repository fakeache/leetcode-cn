package Simple;

import java.util.HashMap;

public class Solution290 {
    public static boolean wordPattern(String pattern, String str) {
        int len1 = pattern.length();
        String[] strArray = str.split(" ");
        int len2 = strArray.length;
        if (len1 != len2) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map1 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char c = pattern.charAt(i);
            String temp = strArray[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(temp)) {
                    return false;
                }
            } else {
                map.put(c, temp);
            }
            if (map1.containsKey(temp)) {
                if (!map1.get(temp).equals(c)) {
                    return false;
                }
            } else {
                map1.put(temp, c);
            }
        }
        return true;
    }

    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }
}