package Middle;

class Solution318 {
    public int maxProduct(String[] words) {
        int max = 0;
        int len = words.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
