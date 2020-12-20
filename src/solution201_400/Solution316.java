package solution201_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Chad li
 * @Date : 2020/3/21 11:25
 * @Version 1.0
 */
public class Solution316 {
    //
    public String removeDuplicateLetters1(String s) {
        StringBuilder ans = new StringBuilder();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a'] ++;
        }
        for(char ch: s.toCharArray()){
            if(!visited[ch -'a']){
                while(ans.length()>0 &&ans.charAt(ans.length() - 1) > ch){
                    if(count[ans.charAt(ans.length() - 1) - 'a']>0){
                        visited[ans.charAt(ans.length() - 1) - 'a'] = false;
                        ans.deleteCharAt(ans.length()-1);
                    }else{
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                ans.append(ch);
            }
            count[ch - 'a']--;
        }
        return ans.toString();
    }

    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
        }
        int pos = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<s.charAt(pos)){
                pos = i;
            }
            if(--counter[s.charAt(i)-'a']==0){
                break;
            }
        }
        return s.length()==0?"": s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));
    }
}
