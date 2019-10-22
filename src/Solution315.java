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

        mergeSort(nums,indexes,0,nums.length-1);
        for(int i = 0; i < indexes.length;i++){
            if(i >= indexes[i]){
                indexes[i] = i - indexes[i];
            } else {
                indexes[i] = 0;
            }
            res.add(indexes[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums,int[] indexs,int start,int end){
        if(end<=start){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, indexs, start, mid);
        mergeSort(nums, indexs, mid+1, end);
        merge(nums,indexs,start,mid,mid+1,end);
    }

    private void merge(int[] nums,int[] indexes,int leftStart,int leftEnd,int rightStart,int rightEnd){
        int[] cache = new int[rightEnd - leftStart + 1];
        int start = leftStart, i = 0;
        while (leftStart<=leftEnd || rightStart<=rightEnd){
            if(leftStart>leftEnd){
                cache[i++] = indexes[rightStart++];
            } else if(rightStart>rightEnd){
                cache[i++] = indexes[leftStart++];
            } else if(nums[indexes[leftStart]] <= nums[indexes[rightStart]]){
                cache[i++] = indexes[leftStart++];
            } else {
                cache[i++] = indexes[rightStart++];
            }
        }
        if (cache.length >= 0) {
            System.arraycopy(cache, 0, indexes, start, cache.length);
        }
    }
}
