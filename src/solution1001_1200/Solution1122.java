package solution1001_1200;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr1){
            map1.put(num,map1.getOrDefault(num,0)+1);
        }
        int offset = 0;
        for (int value : arr2) {
            int count = map1.getOrDefault(value, 0);
            map.put(value, offset);
            offset += count;
        }
        int[] ans = new int[arr1.length];
        for (int i = 0, j = arr1.length -1 ; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                int pos = map.get(arr1[0]);
                ans[pos] = arr1[i];
                map.put(arr1[i],pos + 1);
            }else{
                ans[j--] = arr1[i];
            }
        }
        Arrays.sort(ans,offset, ans.length -1);
        return ans;
    }
}
