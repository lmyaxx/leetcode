import java.util.Deque;
import java.util.LinkedList;

public class SolutionX438 {
    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        int tail = 0, head = 1 ;
        int max = nums[0], min = nums[0];
        while(head<nums.length){
            if(nums[head]>max){
                max = nums[head];
                if(max-min>limit){
                    tail = head;
                    min = max;
                    while(max-nums[tail]<=limit){
                        min = Math.min(nums[tail],min);
                        tail--;
                    }
                    tail++;
                }
            }
            if(nums[head]<min){
                min = nums[head];
                if(max-min>limit){
                    tail = head;
                    max = min;
                    while(nums[tail] - min<=limit){
                        max = Math.max(nums[tail],max);
                        tail--;
                    }
                    tail++;
                }
            }
            res = Math.max(head-tail+1,res);
            head++;
        }
        return res;
    }
    public int longestSubarray1(int[] nums, int limit) {
        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        int res = 0;
        int right =0, left = 0;
        for (;right<nums.length;right++){
            while(!maxD.isEmpty()&&maxD.peekLast()<nums[right]){
                maxD.removeLast();
            }
            maxD.addLast(nums[right]);
            while(!minD.isEmpty()&&minD.peekLast()>nums[right]){
                minD.removeLast();
            }
            minD.addLast(nums[right]);
            while(maxD.peekFirst()-minD.peekFirst()>limit){
                if(maxD.peekFirst()==nums[left]){
                    maxD.pollFirst();
                }
                if(minD.peekFirst()==nums[left]){
                    minD.pollFirst();
                }
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
