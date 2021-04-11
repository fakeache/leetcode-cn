package Middle;

import java.util.Deque;
import java.util.LinkedList;

public class Solution388 {
    public int lengthLongestPath(String input) {
        int rs = 0;
        String[] arr = input.split("\n");
        if (arr.length == 0) {
            return rs;
        }
        Deque<int[]> stk = new LinkedList<>();
        // int[a, b, c] a为层数，b为绝对路径长度，c表示是否为文件
        for (int i = 0; i < arr.length; i++) {
            String rStr = arr[i];
            int strLen = rStr.length();
            int[] node = null;
            int tnum = 0;
            for (int j = 0; j < strLen; j++) {
                if (rStr.charAt(j) == '\t') {
                    tnum++;
                } else {
                    break;
                }
            }
            while (!stk.isEmpty()) {
                int[] pre = stk.peekLast();
                if (tnum > pre[0]) {
                    node = new int[]{tnum, pre[1] + rStr.length() + 1 - tnum,
                            rStr.contains(".") ? 1 : 0};
                    stk.addLast(node);
                    break;
                } else {
                    pre = stk.removeLast();
                    if (pre[2] == 1) {
                        rs = Math.max(rs, pre[1] - 1);
                    }
                }
            }
            if (stk.isEmpty()) {
                node = new int[]{0, rStr.length() + 1, rStr.contains(".") ? 1 : 0};
                stk.addLast(node);
            }
        }
        if (!stk.isEmpty()) {
            int[] top = stk.removeLast();
            if (top[2] == 1) {
                rs = Math.max(rs, top[1] - 1);
            }
        }
        return rs;
    }
}
