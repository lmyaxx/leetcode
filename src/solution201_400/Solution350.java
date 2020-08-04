package solution201_400;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/1/10 21:47
 * @Version 1.0
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int num:nums2){
            map2.put(num,map2.getOrDefault(num,0) + 1);
        }
        for(int num:nums1){
            int count = map2.getOrDefault(num, 0);
            if(count != 0){
                result.add(num);
                map2.put(num,count-1);
            }
        }
        int [] res = new int [result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
