import java.util.ArrayList;
/**
 * LeetCode
 * 211. Add and Search Word - Data structure design
 * @company: Facebook
 * @author lorreina
 *
 */
public class Add_and_Search_Word {
	public class WordDictionary {
	    
	    private Node root;
	    public WordDictionary () {
	        this.root = new Node('r');
	    }
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        if (word == null || word.length() == 0) {
	            return;
	        }
	        int i = 0;
	        Node current = root;
	        
	        for (i = 0; i < word.length(); i++) {
	            boolean goNext = false;
	            for (int j = 0; j < current.list.size(); j++) {
	                if (current.list.get(j).value == word.charAt(i)) {
	                    current = current.list.get(j);
	                    goNext = true;
	                    break;
	                }
	            }
	            if (!goNext) {
	                break;
	            }
	        }
	        for (int j = i; j < word.length(); j++) {
	            current.list.add(new Node(word.charAt(j)));
	            current = current.list.get(current.list.size() - 1);
	        }
	        current.isWord = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        if (word == null || word.length() == 0) {
	            return false;
	        }
	        
	        return helper(word, root);
	    }
	    
	    private boolean helper(String word, Node current) {
	        if (word == null || word.length() == 0) {
	            return current.isWord;
	        }
	        
	        String next = word.substring(1, word.length());
	        if (word.charAt(0) == '.') {
	            boolean hasWord = false;
	            for (int i = 0; i < current.list.size(); i++) {
	                if (helper(next, current.list.get(i))) {
	                    hasWord = true;
	                }
	            }
	            return hasWord;
	        } else {
	            for (int i = 0; i < current.list.size(); i++) {
	                if (current.list.get(i).value == word.charAt(0)) {
	                    return helper(next, current.list.get(i));
	                }
	            }
	            return false;
	        }
	    }
	    
	    public class Node {
	        public char value;
	        public ArrayList<Node> list;
	        public boolean isWord;
	        
	        public Node(char value) {
	            this.value = value;
	            this.list = new ArrayList<Node> ();
	            isWord = false;
	        }
	        
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
