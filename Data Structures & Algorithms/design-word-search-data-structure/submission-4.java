class TrieNode {
    TrieNode[] children;
    boolean endWord;

    public TrieNode() {
        children = new TrieNode[26];
        endWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char w : word.toCharArray()) {
            if (curr.children[w - 'a'] == null) {
                curr.children[w - 'a'] = new TrieNode();
            }
            
            curr = curr.children[w - 'a'];
        }

        curr.endWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        return dfs(curr, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i) {
        if (node == null) {
            return false;
        }

        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);

            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && dfs(child, word, j + 1)) {
                        return true;
                    } 
                }
                return false;
            } else {
                if (node.children[c - 'a'] == null) {
                    return false;
                } 
                node = node.children[c - 'a'];
            }
        }
        return node.endWord;
    }
}
