package Common;

/**
 * @Author : Chad li
 * @Date : 2020/3/11 10:03
 * @Version 1.0
 */
public class WordDictionary {

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word,this.root);
    }
    private boolean helper(String word,TrieNode cur){
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int k = 0; k<26;k++){
                    if(cur.children[k]!=null&&helper(word.substring(i+1),cur.children[k])){
                        return true;
                    }
                }
                return false;
            }else{
                if(cur.children[ch-'a']==null) {
                    return false;
                }
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */