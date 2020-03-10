import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/3/10 11:17
 * @Version 1.0
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        return helper(s,t)&&helper(t,s);
    }

    private boolean helper(String s, String t){
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
