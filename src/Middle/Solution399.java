package Middle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int l1 = equations.size();
        UnionFind uf = new UnionFind(2 * l1);
        Map<String, Integer> map = new HashMap<>(2 * l1);
        int index = 0;
        for (int i = 0; i < l1; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!map.containsKey(a)) {
                map.put(a, index++);
            }
            if (!map.containsKey(b)) {
                map.put(b, index++);
            }
            uf.union(map.get(a), map.get(b), values[i]);
        }
        int l2 = queries.size();
        double[] rs = new double[l2];
        for (int i = 0; i < l2; i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!map.containsKey(c) || !map.containsKey(d)) {
                rs[i] = -1.0;
                continue;
            }
            rs[i] = uf.isConnected(map.get(c), map.get(d));
        }
        return rs;
    }

    class UnionFind {

        int[] parent;
        double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x] ;
        }

        public int find(int x) {
            if (parent[x] != x) {
                int tmp = parent[x];
                parent[x] = find(tmp);
                weight[x] *= weight[tmp];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY ? weight[x] / weight[y] : -1.0;
        }
    }
}
