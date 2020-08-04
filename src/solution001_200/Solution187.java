package solution001_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : Chad li
 * @Date : 2020/3/5 10:45
 * @Version 1.0
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen  = new HashSet<>();
        Set repeated = new HashSet();
        for(int i=0; i+9<s.length();i++){
            String str = s.substring(i,i+10);
            if(seen.contains(str)){
                repeated.add(str);
            }else{
                seen.add(str);
            }
        }
        return new ArrayList<>(repeated);
    }
}
