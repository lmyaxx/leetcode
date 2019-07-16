import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
