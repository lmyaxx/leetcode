import Common.Trie;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/4/27 19:44
 * @Version 1.0
 */

public class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String word:words){
            if(canForm(set,word)){
                ans.add(word);
            }
            set.add(word);
        }
        return ans;
    }
    private boolean canForm(Set<String> set, String word){
        if(set.isEmpty()){
            return false;
        }
        //dp[i] means if the first i chars can be formed by set
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        for(int i=1;i<=word.length();i++){
            for(int j=0;j<i;j++){
                if(!dp[j]){
                    continue;
                }
                if(set.contains(word.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        // construct Trie tree
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            addWord(root,word);
        }
        // test word is a concatenated word or not
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (testCanForm(word.toCharArray(), 0, root, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean testCanForm(char[] word, int idx, TrieNode root, int count){
        TrieNode cur = root;
        for(int i=idx;i<word.length;i++){
            if(cur.children[word[i]-'a']==null){
                return false;
            }
            cur = cur.children[word[i]-'a'];
            if(cur.isWord){
                if(i == word.length-1){
                    return count>=1;
                }
                if(testCanForm(word,i+1,root,count+1)){
                    return true;
                }
            }
        }
        return false;
    }


    private void addWord(TrieNode root, String word){
        for (char ch : word.toCharArray()){
            if(root.children[ch-'a']==null){
                root.children[ch-'a'] = new TrieNode();
            }
            root = root.children[ch-'a'];
        }
        root.isWord = true;
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
