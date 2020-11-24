package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution93 {
    List<String> rsList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, "", 1, 0);
        return rsList;
    }

    void dfs(String s, String os, int b, int k) {
        if (b == 5 && k == s.length()) {
            rsList.add(os);
            return;
        }
        if (b == 5) {
            return;
        }
        String c = "";
        int value = 0;
        for (int i = 0; i < 3; i++) {
            if (k + i >= s.length()) {
                break;
            }
            c = c + s.charAt(k + i);
            value  = value * 10 + s.charAt(k + i) - '0';
            if (i == 1 && value < 10) {
                break;
            }
            if (i == 2 && value < 100) {
                break;
            }
            if (value > 255) {
                break;
            }
            String tmps = os + c;
            if (b < 4) {
                tmps += ".";
            }
            dfs(s, tmps, b + 1, k + i + 1);
        }
    }
}