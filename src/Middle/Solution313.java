package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] rs = new int[n];
        int len = primes.length;
        int[] idx = new int[len];
        rs[0] = 1;
        for (int i = 1; i < n; i++) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                int tmp = rs[idx[j]] * primes[j];
                if (tmp < min) {
                    list = new ArrayList<>();
                    list.add(j);
                    min = tmp;
                } else if (tmp == min) {
                    list.add(j);
                }
            }
            rs[i] = min;
            for (int x : list) {
                idx[x]++;
            }
        }
        return rs[n - 1];
    }
}
