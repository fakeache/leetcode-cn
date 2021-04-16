package Middle;

public class Solution423 {
    public String originalDigits(String s) {
        int len = s.length();
        int[] cr = new int[26];
        int[] count = new int[10];
        for (int i = 0; i < len; i++) {
            cr[s.charAt(i) - 'a']++;
        }
        count[0] = cr['z' - 'a'];
        count[2] = cr['w' - 'a'];
        count[8] = cr['g' - 'a'];
        count[4] = cr['u' - 'a'];
        count[6] = cr['x' - 'a'];
        count[5] = cr['f' - 'a'] - count[4];
        count[3] = cr['h' - 'a'] - count[8];
        count[7] = cr['s' - 'a'] - count[6];
        count[9] = cr['i' - 'a'] - count[5] - count[6] - count[8];
        count[1] = cr['o' - 'a'] - count[2] - count[4] - count[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString();
    }
}
