package Middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        List<List<Integer>> list = new ArrayList<>();
        int[] entry = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();
        int[] rsArr = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            entry[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (entry[i] == 0) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            int ele = queue.removeFirst();
            rsArr[index++] = ele;
            for (int x : list.get(ele)) {
                entry[x]--;
                if (entry[x] == 0) {
                    queue.addLast(x);
                }
            }
        }
        if (index == numCourses) {
            return rsArr;
        } else {
            return new int[0];
        }
    }
}