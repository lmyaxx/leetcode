package solution201_400;

import Common.Trie;
import org.junit.Test;

public class Solution208 {
    @Test
    public void test_Solution(){
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }
}
