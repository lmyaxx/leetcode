package solution001_200;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()];
        for(int i=0,len=s.length();i<len;i++){
            if(set.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(dp[j-1]&&set.contains(s.substring(j,i+1))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        //res[i] means if it is true for s.substring(0,i);
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        HashSet<String> dict = new HashSet<String>();
        int max = 0,min=Integer.MAX_VALUE;
        for(String word : wordDict){
            max = Math.max(max,word.length());
            min = Math.min(min,word.length());
            dict.add(word);
        }
        //list[i] means the s.substring(0,list[i]) is true;
        //list[i] is the length of s.substring(0,list[i]);
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(0);
        for(int i=0;i<s.length();i++){
            while(!list.isEmpty()&&list.peekFirst()<(i+1)-max){
                list.pollFirst();
            }
            if(list.isEmpty()){
                return false;
            }
            Iterator<Integer> iterator =  list.iterator();
            while(iterator.hasNext()){
                int start = iterator.next();
                String sub = s.substring(start,i+1);
                if(dict.contains(sub)){
                    res[i+1] = true;
                    list.addLast(i+1);
                    break;
                }
                if(i+1-start<min){
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
