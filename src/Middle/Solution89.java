package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> pre = new ArrayList<>();
        pre.add(0);
        for (int i = 1; i <= n; i++) {
            List<Integer> back = new ArrayList<>(pre);
            int c = (int)Math.pow(2, i - 1);
            for (int j = pre.size() - 1; j >= 0; j--) {
                back.add(pre.get(j) + c);
            }
            pre = back;
        }
        return pre;
    }
}