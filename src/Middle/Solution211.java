package Middle;

class Solution211 {

    TrieNode root;

    class TrieNode {

        boolean isEnd;
        TrieNode[] trieArr;

        public TrieNode() {
            this.trieArr = new TrieNode[26];
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public void add(char c) {
            trieArr[c - 'a'] = new TrieNode();
        }

        public boolean containsKey(char c) {
            return trieArr[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return trieArr[c - 'a'];
        }
    }

    /** Initialize your data structure here. */
    public Solution211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.add(c);
            }
            node = node.get(c);
        }
        node.setIsEnd(true);
    }

    public boolean search(String word) {
        return searchNode(root, word, 0);
    }

    public boolean searchNode(TrieNode node, String word, int start) {
        if (start == word.length()) {
            return node.isEnd();
        }
        char c = word.charAt(start);
        if (c != '.') {
            if (node.containsKey(c)) {
                return searchNode(node.get(c), word, start + 1);
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.containsKey((char) (i + 'a'))) {
                    if (searchNode(node.get((char) (i + 'a')), word, start + 1)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
