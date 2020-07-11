import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        int[] list = new int[nums.length];
        mergeSort(nums,indexes,0,nums.length-1,list);
        for(int i = 0; i < list.length;i++){
            res.add(list[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums,int[] indexes,int start,int end,int [] res){
        if(end<=start){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, indexes, start, mid,res);
        mergeSort(nums, indexes, mid+1, end,res);
        merge(nums,indexes,start,mid,mid+1,end, res);
    }

    private void merge(int[] nums,int[] indexes,int leftStart,int leftEnd,int rightStart,int rightEnd,int[] res){
        int[] cache = new int[rightEnd - leftStart + 1];
        int start = leftStart, i = 0;
        int count = 0;
        while (leftStart<=leftEnd || rightStart<=rightEnd){
            if(leftStart>leftEnd){
                cache[i++] = indexes[rightStart++];
            } else if(rightStart>rightEnd){
                res[indexes[leftStart]] += count;
                cache[i++] = indexes[leftStart++];
            } else if(nums[indexes[leftStart]] <= nums[indexes[rightStart]]){
                res[indexes[leftStart]] += count;
                cache[i++] = indexes[leftStart++];
            } else {
                cache[i++] = indexes[rightStart++];
                count++;
            }
        }
        if (cache.length >= 0) {
            System.arraycopy(cache, 0, indexes, start, cache.length);
        }
    }
}
