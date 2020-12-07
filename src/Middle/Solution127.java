package Middle;

import java.util.*;

class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int rs = 0;
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int len = queue.size();
            rs++;
            for (int i = 0; i < len; i++) {
                String curWord = queue.poll();
                char[] curArr = curWord.toCharArray();
                for (int j = 0; j < curArr.length; j++) {
                    char origin = curArr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (curArr[j] == k) {
                            continue;
                        }
                        curArr[j] = k;
                        String newWord = String.valueOf(curArr);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return rs + 1;
                            }
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    curArr[j] = origin;
                }
            }
        }
        return 0;
    }
}
