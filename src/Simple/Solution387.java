package Simple;

public class Solution387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] hash = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            hash[c - 'a'] = hash[c - 'a'] == 0 ? i + 1 : -1;
        }
        int rs = Integer.MAX_VALUE;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                rs = Math.min(rs, hash[i] - 1);
            }
        }
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
}
