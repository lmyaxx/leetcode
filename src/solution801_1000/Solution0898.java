package solution801_1000;

import java.util.HashSet;
import java.util.Set;

public class Solution0898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for(int num: A){
            for(Integer n: cur){
                int newNum = n | num;
                temp.add(newNum);
                ans.add(newNum);
            }
            temp.add(num);
            ans.add(num);
            Set<Integer> cache = cur;
            cur = temp;
            temp = cache;
            temp.clear();
        }
        return ans.size();
    }
}
