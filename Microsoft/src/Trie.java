import java.util.HashMap;

class TrieNode {
    // Initialize your data structure here.
    public char alpha;
    public boolean isWord;
    public HashMap<Character, TrieNode> child;
    public TrieNode() {
        child = new HashMap<Character, TrieNode> ();
    }
    
    public TrieNode(char alpha) {
        this.alpha = alpha;
        child = new HashMap<Character, TrieNode> ();
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (root == null || word.length() == 0) {
            return;
        }
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (pointer.child.containsKey(tmp)) {
                pointer = pointer.child.get(tmp);
            } else {
                pointer = addWord(pointer, i, word);
                break;
            }
        }
        pointer.isWord = true;
    }
    
    private TrieNode addWord(TrieNode pointer, int i, String word) {
        for (; i < word.length(); i++) {
            TrieNode tmp = new TrieNode(word.charAt(i));
            pointer.child.put(word.charAt(i), tmp);
            pointer = tmp;
        }
        return pointer;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (pointer.child.containsKey(tmp)) {
                pointer = pointer.child.get(tmp);
            } else {
                return false;
            }
        }
        return pointer.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        TrieNode pointer = root;
        for (int i = 0; i < prefix.length(); i++) {
            char tmp = prefix.charAt(i);
            if (pointer.child.containsKey(tmp)) {
                pointer = pointer.child.get(tmp);
            } else {
                return false;
            }
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");