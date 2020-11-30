public class Solution1674 {
    public int minMoves(int[] nums, int limit) {
        int[] take = new int[2 + limit * 2];
        int len = nums.length;
        for(int i = 0; i < len / 2; i++){
            int left = nums[i], right = nums[len - 1 - i];
            int low = Math.min(left,right) + 1;
            int sum = left + right;
            int high = Math.max(left, right) + limit;
            take[low] -= 1;
            take[sum] -= 1;
            take[sum + 1] += 1;
            take[high + 1] += 1;
        }
        int ans = Integer.MAX_VALUE;
        int sum = len;
        for(int i = 2; i <= 2* limit; i++){
            sum += take[i];
            ans = Math.min(sum ,ans);
        }
        return ans;
    }
}
