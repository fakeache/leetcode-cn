package Simple;

import java.util.HashMap;
import java.util.Map;

class Solution771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int jlen = J.length();
        for (int i = 0; i < jlen; i++) {
            map.put(J.charAt(i), 1);
        }
        int rs = 0;
        int slen = S.length();
        for (int j = 0; j < slen; j++) {
            if (map.containsKey(S.charAt(j))) {
                rs++;
            }
        }
        return rs;
    }
}