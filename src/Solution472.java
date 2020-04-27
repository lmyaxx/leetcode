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
}
