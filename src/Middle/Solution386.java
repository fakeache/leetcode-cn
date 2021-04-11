package Middle;

import java.util.LinkedList;
import java.util.List;

public class Solution386 {

    List<Integer> rs = new LinkedList<>();
    String ns;
    int len;

    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            return rs;
        }
        this.ns = String.valueOf(n);
        this.len = ns.length();
        dfs("");
        return rs;
    }

    public void dfs(String str) {
        if (str.length() > len) {
            return;
        }
        if (str.length() == len && str.compareTo(ns) > 0) {
            return;
        }
        if (!"".equals(str)) {
            rs.add(Integer.valueOf(str));
        }
        for (int i = 0; i < 10; i++) {
            if ("".equals(str) && i == 0) {
                continue;
            }
            dfs(new String(str + (char) ('0' + i)));
        }
    }
}
