package Middle;

import java.util.HashMap;
import java.util.Map;

class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long numer = Math.abs(Long.valueOf(numerator));
        long denomin = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(numer / denomin));
        long rest = numer % denomin;
        if (rest == 0) {
            return sb.toString();
        }
        sb.append(".");
        int pos = sb.indexOf(".") + 1;
        Map<Long, Integer> map = new HashMap<>();
        while (rest != 0) {
            if (!map.containsKey(rest)) {
                map.put(rest, pos);
            } else {
                sb.insert(map.get(rest), "(");
                sb.append(")");
                return sb.toString();
            }
            sb.append(String.valueOf(rest * 10 / denomin));
            pos++;
            rest = (rest * 10) % denomin;
        }
        return sb.toString();
    }
}
