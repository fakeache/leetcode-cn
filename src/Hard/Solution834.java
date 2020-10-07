package Hard;

import java.util.*;

class Solution834 {
    int[] dp;
    int[] uz;
    int[] rs;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 1) {
            return new int[]{0};
        }
        for (int[] arr : edges) {
            List<Integer> list0 = map.getOrDefault(arr[0], new LinkedList<>());
            list0.add(arr[1]);
            map.put(arr[0], list0);
            List<Integer> list1 = map.getOrDefault(arr[1], new LinkedList<>());
            list1.add(arr[0]);
            map.put(arr[1], list1);
        }
        dp = new int[N];
        uz = new int[N];
        rs = new int[N];
        dfsEdgeSum(0, -1);
        rs[0] = dp[0];
        dfsEdgeSum2(0, -1);
        return rs;
    }

    public void dfsEdgeSum(int i, int parent) {
        List<Integer> list = map.get(i);
        int sum = 0;
        int nodeNum = 1;
        for (Integer son : list) {
            if (son == parent) {
                continue;
            }
            dfsEdgeSum(son, i);
            sum += dp[son] + uz[son];
            nodeNum += uz[son];
        }
        dp[i] = sum;
        uz[i] = nodeNum;
    }

    public void dfsEdgeSum2(int i, int parent) {
        List<Integer> list = map.get(i);
        for (Integer son : list) {
            if (son == parent) {
                continue;
            }
            dp[i] = dp[i] - dp[son] - uz[son];
            uz[i] = uz[i] - uz[son];
            dp[son] = dp[son] + dp[i] + uz[i];
            uz[son] = uz[son] + uz[i];
            rs[son] = dp[son];
            dfsEdgeSum2(son, i);
            uz[son] = uz[son] - uz[i];
            dp[son] = dp[son] - dp[i] - uz[i];
            uz[i] = uz[i] + uz[son];
            dp[i] = dp[i] + dp[son] + uz[son];
        }
    }

    public static void main(String[] args) {
        Solution834 solution = new Solution834();
        int[][] arr = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, arr)));
    }
}
