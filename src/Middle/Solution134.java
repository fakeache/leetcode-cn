package Middle;

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int begin = 0;
        while (begin < len) {
            int gasSum = 0, costSum = 0;
            for (int i = 0; i < len; i++) {
                int index = (i + begin) % len;
                gasSum += gas[index];
                costSum += cost[index];
                if (gasSum < costSum) {
                    begin = begin + i + 1;
                    break;
                }
                if (i == len - 1 && gasSum >= costSum) {
                    return begin;
                }
            }
        }
        return -1;
    }
}
