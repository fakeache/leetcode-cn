package Middle;

import java.util.Arrays;

class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i && (i == 0 || citations[i - 1] <= len - i)) {
                h = len - i;
                break;
            }
        }
        return h;
    }
}
