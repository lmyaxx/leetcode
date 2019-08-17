import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        int min = nums[0],max=nums[0];
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] bucketsMIN = new int[nums.length-1];
        int[] bucketsMAX = new int[nums.length-1];
        Arrays.fill(bucketsMAX,Integer.MIN_VALUE);
        Arrays.fill(bucketsMIN,Integer.MAX_VALUE);
        for(int num:nums){
            if(num==min||num==max)
                continue;
            int idx = (num-min)/gap;
            bucketsMIN[idx] = Math.min(bucketsMIN[idx],num);
            bucketsMAX[idx] = Math.max(bucketsMAX[idx],num);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i=0;i<nums.length-1;i++){
            if(bucketsMAX[i]==Integer.MIN_VALUE&&bucketsMIN[i]==Integer.MAX_VALUE)
                continue;
            maxGap = Math.max(bucketsMIN[i]-previous,maxGap);
            previous = bucketsMAX[i];
        }
        maxGap=Math.max(maxGap,max-previous);
        return maxGap;
    }
}
