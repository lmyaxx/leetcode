package solution001_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        add(0,nums.length-1,nums,result);
        return result;
    }
    public void add(int start,int end,int [] nums,List<List<Integer>> result){
        if(start==end){
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
        }else{
            for(int i=start;i<=end;i++){
                int j = i - 1;
                while (j >= start && nums[j] != nums[i]) --j;
                if (j != start - 1) continue;
                swap(nums,start,i);
                add(start+1,end,nums,result);
                swap(nums,start,i);
            }
        }
    }
    public void swap(int [] nums,int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
