package Middle;

class Solution12 {
    public String intToRoman(int num) {
        int[] arr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (num >= arr[i]) {
                num -= arr[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}