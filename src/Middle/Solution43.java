package Middle;

class Solution43 {
    public String multiply(String num1, String num2) {
        String b = num1.length() >= num2.length() ? num1 : num2;
        String s = num1.length() >= num2.length() ? num2 : num1;
        String rs = "0";
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--, k++) {
            String singRs = singleMultiply(b, s.charAt(i) - '0');
            for (int j = 0; j < k; j++) {
                singRs += '0';
            }
            rs = add(singRs, rs);
        }
        return rs;
    }

    public String singleMultiply(String num1, int y) {
        if (num1 == null || num1.length() == 0 || y == 0) {
            return "0";
        }
        int len = num1.length();
        StringBuilder sb = new StringBuilder();
        int b = 0;
        for (int i = len - 1; i >= 0; i--) {
            int a = (num1.charAt(i) - '0') * y + b;
            sb.append((char) (a % 10 + '0'));
            b = a / 10;
        }
        if (b > 0) {
            sb.append((char) (b + '0'));
        }
        return sb.reverse().toString();
    }

    public String add(String num1, String num2) {
        String big;
        String small;
        if (num1.length() >= num2.length()) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }
        int blen = big.length();
        int slen = small.length();
        int b = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = blen - 1, j = slen - 1; i >= 0; i--, j--) {
            int y = j >= 0 ? small.charAt(j) - '0' : 0;
            int x = big.charAt(i) - '0';
            int rs = x + y + b;
            sb.append((char) (rs % 10 + '0'));
            b = rs / 10;
        }
        if (b > 0) {
            sb.append((char) (b + '0'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        System.out.println(solution.multiply("16", "311"));
    }
}