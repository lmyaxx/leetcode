import java.util.*;

public class Solution1477 {


    public int minSumOfLengths(int[] arr, int target) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>(arr.length+1);
        map.put(sum,-1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            map.put(sum,i);
        }
        int minL = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.get(sum-target)!=null){
                minL = Math.min(minL, i - map.get(sum-target));
            }
            if(minL<Integer.MAX_VALUE&&map.get(sum+target)!=null){
                res = Math.min(res,minL+map.get(sum+target)-i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
