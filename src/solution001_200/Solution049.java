package solution001_200;

import java.util.*;

public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> store =  new HashMap<>();
        for (String s:strs) {
            char str[] = s.toCharArray();
            Arrays.sort(str);
            String sss = String.valueOf(str);
            if(!store.containsKey(sss)){
                store.put(sss,new ArrayList<String>());
            }
            store.get(sss).add(s);
        }
        return new ArrayList<List<String>>(store.values());
    }
}
