package Common;



public class Trie {
    private TrieNode root;


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot(){
        return root;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
       TrieNode cur = root;
       for(int i=0;i<word.length();i++){
           char ch = word.charAt(i);
           if(cur.children[ch-'a']==null){
               cur.children[ch-'a'] = new TrieNode();
           }
           cur = cur.children[ch-'a'];
       }
       cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null) return false;
            cur = cur.children[ch-'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch-'a']==null) return false;
            cur = cur.children[ch-'a'];
        }
        return true;
    }
}
