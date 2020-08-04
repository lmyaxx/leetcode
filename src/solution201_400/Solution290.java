package solution201_400;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/3/21 9:01
 * @Version 1.0
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" +");
        if(words.length!=pattern.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            Integer pos1 = map1.put(pattern.charAt(i), i);
            Integer pos2 = map2.put(words[i], i);
            if((pos1==null)^(pos2==null)||(pos1!=null&&!pos1.equals(pos2))){
                return false;
            }
        }
        return true;
    }
}
