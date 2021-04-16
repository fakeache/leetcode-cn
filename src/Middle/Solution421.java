package Middle;

import java.util.HashMap;
import java.util.Map;

public class Solution421 {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = Integer.toBinaryString(max).length();
        int maxXor = 0;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            int bit = 1 << l;
            int xor = 0;
            String numStr = Integer.toBinaryString(num | bit).substring(1);
            TrieNode node = root, xorNode = root;
            for (char c : numStr.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                char xorC = c == '1' ? '0' : '1';
                if (xorNode.children.containsKey(xorC)) {
                    xor = (xor << 1) | 1;
                    xorNode = xorNode.children.get(xorC);
                } else {
                    xor = xor << 1;
                    xorNode = xorNode.children.get(c);
                }
            }
            maxXor = Math.max(maxXor, xor);
        }
        return maxXor;
    }
}
