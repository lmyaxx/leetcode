package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution1713 {
    public int respace(String[] dictionary, String sentence) {
        HashSet<String> dict = new HashSet<String>(dictionary.length);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (String word: dictionary ) {
            treeSet.add(word.length());
            dict.add(word);
        }
        int[] dp = new int[sentence.length()+1];
        dp[0] = 0;
        for (int i = 0; i < sentence.length(); i++) {
            for(int len : treeSet){
                if(i-len+1<0){
                    break;
                }
                String word =  sentence.substring(i-len+1,i+1);

                if(dict.contains(word)){
                    dp[i+1] = Math.max(dp[i+1],dp[i+1-len] + len);
                }
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        return sentence.length() - dp[sentence.length()];

    }
}
