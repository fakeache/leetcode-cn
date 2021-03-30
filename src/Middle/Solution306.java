package Middle;

class Solution306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int len = num.length();
        for (int i = 0; i < len - 1; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    continue;
                }
                long a = Long.valueOf(num.substring(0, i + 1));
                long b = Long.valueOf(num.substring(i + 1, j + 1));
                if (valid(a, b, num.substring(j + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(long a, long b, String input) {
        while (true) {
            long c = a + b;
            String cstr = String.valueOf(c);
            int bit = 1;
            long tmp = c;
            while (tmp / 10 != 0) {
                bit++;
                tmp = tmp / 10;
            }
            if (input.length() < bit ||!cstr.equals(input.substring(0, bit))) {
                return false;
            }
            if (cstr.equals(input)) {
                return true;
            }
            input = input.substring(bit);
            a = b;
            b = c;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution306().isAdditiveNumber("199100199"));
    }
}
