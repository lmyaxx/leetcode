public class SolutionX470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int half = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            if(i<half){
                res[i*2] = nums[i];
            }else{
                res[(i-half)*2+1]= nums[i];
            }
        }
        return res;
    }
}
