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
//        Map<Character,Integer> pos = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            counter[ch-'a']--;
            for(int j=sb.length()-1;j>=0;j--){
                if(sb.charAt(j)>ch){
                    if(counter[sb.charAt(j)-'a']>0){
                        set.remove(sb.charAt(j));
                        sb.deleteCharAt(j);
                    }else{
                        break;
                    }
                }
            }
            if(!set.contains(ch)){
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
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
