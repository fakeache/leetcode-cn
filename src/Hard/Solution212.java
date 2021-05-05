package Hard;

import java.util.*;

public class Solution212 {
    class TrieNode {
        public boolean isEnd;
        public String str;
        public Map<Character, TrieNode> map = new HashMap<>();
    }
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> rs = new HashSet<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] warr = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < warr.length; i++) {
                if (!node.map.containsKey(warr[i])) {
                    node.map.put(warr[i], new TrieNode());
                }
                node = node.map.get(warr[i]);
            }
            node.isEnd = true;
            node.str = word;
        }
        int[][] direction = new int[][]{{1,0}, {-1,0}, {0, 1}, {0, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new HashSet<>(), rs, direction);
            }
        }
        return new ArrayList<>(rs);
    }

    public void dfs(char[][] board, int x, int y, TrieNode node, Set<Integer> set,      Set<String> rs, int[][] direction) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        int m = board.length, n = board[0].length;
        if (set.contains(n * x + y)) {
            return;
        }
        char cur = board[x][y];
        if (!node.map.containsKey(cur)) {
            return;
        }
        node = node.map.get(cur);
        if (node.isEnd) {
            rs.add(node.str);
        }
        set.add(n * x + y);
        for (int[] dir : direction) {
            dfs(board, x + dir[0], y + dir[1], node, set, rs, direction);
        }
        set.remove(n * x + y);
    }

    public static void main(String[] args) {
        new Solution212().findWords(new char[][]{{'a','b','c','e'},{'x','x','c','d'},{'x','x','b','a'}}, new String[]{"abc","abcd"});
    }
}
