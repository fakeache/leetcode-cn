package Middle;

import java.util.Arrays;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] rs = new int[people.length][];
        Arrays.sort(people, (people1, people2) -> {
            if (people1[0] != people2[0]) {
                return people1[0] - people2[0];
            } else {
                return people2[1] - people1[1];
            }
        });
        for (int i = 0; i < people.length; i++) {
            int level = people[i][1] + 1;
            for (int j = 0; j < people.length; j++) {
                if (rs[j] == null) {
                    level--;
                    if (level == 0) {
                        rs[j] = people[i];
                        break;
                    }
                }
            }
        }
        return rs;
    }
}
