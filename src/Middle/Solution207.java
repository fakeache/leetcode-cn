package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution207 {
    List<List<Integer>> input;
    int[] status;
    boolean isValid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        input = new ArrayList<>();
        status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            input.add(new ArrayList<>());
        }
        for (int m = 0; m < prerequisites.length; m++) {
            int[] ele = prerequisites[m];
            int a = ele[0];
            int b = ele[1];
            input.get(b).add(a);
        }
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                dfs(i);
            }
        }
        return isValid;
    }

    public void dfs(int u) {
        status[u] = 1;
        for (int v : input.get(u)) {
            if (status[v] == 0) {
                dfs(v);
                if (!isValid) {
                    return;
                }
            } else if (status[v] == 1) {
                isValid = false;
                return;
            }
        }
        status[u] = 2;
    }

}