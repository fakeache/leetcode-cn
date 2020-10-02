package Middle;

class Solution8 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        boolean canTransfer = false;
        boolean isPositive = false;
        for (int i = 0; i < len; i++) {
            if (!canTransfer) {
                if (str.charAt(i) == ' ') {
                    continue;
                } else if (str.charAt(i) == '-') {
                    canTransfer = true;
                } else if (str.charAt(i) == '+') {
                    canTransfer = true;
                    isPositive = true;
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    canTransfer = true;
                    isPositive = true;
                    sb.append(str.charAt(i));
                } else {
                    return 0;
                }
            } else {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                } else {
                    break;
                }
            }
        }
        // 全为空格
        if (!canTransfer) {
            return 0;
        }
        String numStr = sb.toString();
        // 只有一个-号
        if (numStr == null || numStr.length() == 0) {
            return 0;
        }
        int rs = 0;
        int numLen = numStr.length();
        if (isPositive) {
            for (int i = 0; i < numLen; i++) {
                if (rs > (Integer.MAX_VALUE - numStr.charAt(i) + '0') / 10) {
                    return Integer.MAX_VALUE;
                }
                rs = rs * 10 + numStr.charAt(i) - '0';
            }
        } else {
            for (int i = 0; i < numLen; i++) {
                if (rs < (Integer.MIN_VALUE + numStr.charAt(i) - '0') / 10) {
                    return Integer.MIN_VALUE;
                }
                rs = rs * 10 - numStr.charAt(i) + '0';
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        solution8.myAtoi("-91283472332");
    }
}