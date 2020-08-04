package solution201_400;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/1/28 11:29
 * @Version 1.0
 */
public class Solution395 {
    public int longestSubstring(String s, int k) {
        int count=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int left=0;
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))<k){
                count = Math.max(longestSubstring(s.substring(left,i),k),count);
                left = i + 1;
            }
        }
        if(left==0){
            return s.length();
        }else {
            return Math.max(longestSubstring(s.substring(left,s.length()),k),count);
        }
    }
}
