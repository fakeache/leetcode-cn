package Middle;

class Trie208 {

    TrieNode trie;

    /** Initialize your data structure here. */
    public Trie208() {
        trie = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (!node.containsNext(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (!node.containsNext(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = trie;
        for (char c : prefix.toCharArray()) {
            if (!node.containsNext(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}

class TrieNode {
    final int L = 26;
    boolean isEnd;
    TrieNode[] arr;

    public TrieNode() {
        arr = new TrieNode[L];
    }

    public TrieNode[] getArr() {
        return arr;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void put(char c) {
        arr[c - 'a'] = new TrieNode();
    }

    public boolean containsNext(char c) {
        return arr[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return arr[c - 'a'];
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
