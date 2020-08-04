package solution001_200;

import java.util.*;
//"barfoothefoobarman"
//["foo","bar"]
public class Solution030 {
    public List<Integer> findSubstring(String s, String[] words) {
        int count = words.length;
        List<Integer> result = new ArrayList<>();
        if(count==0) return new ArrayList<>();
        Map<String,Integer> word_count = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            word_count.put(word,word_count.getOrDefault(word,0)+1);
        }
        int gap=words[0].length();
        for(int i=0,end=s.length()-gap*count;i<=end;i++){
            map.clear();
            String word;
            int j=0;
            for(;j<count;j++){
                word = s.substring(i+j*gap,i+j*gap+gap);
                int num = map.getOrDefault(word,0);
                if(num<word_count.getOrDefault(word,0)){
                    map.put(word,num+1);
                }else{
                    break;
                }
            }
            if(j==count){
                result.add(i);
            }
        }
        return result;
    }

}
