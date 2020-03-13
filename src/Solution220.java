import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/3/12 9:46
 * @Version 1.0
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<=0||t<0){
            return false;
        }
        Map<Long,Long> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long)t+1);
            if(map.containsKey(bucket)||
                    map.containsKey(bucket-1)&& remappedNum - map.get(bucket-1)<=t||
                    map.containsKey(bucket+1)&& map.get(bucket+1) - remappedNum <=t){
                return true;
            }
            map.put(bucket,remappedNum);
            if(map.entrySet().size()>k){
                long oldBucket = ((long)nums[i-k] - Integer.MIN_VALUE) / ((long)t+1);
                map.remove(oldBucket);
            }
        }
        return false;
    }
}

