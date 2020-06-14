import java.util.Arrays;

public class SolutionX300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int cur=0, len = arr.length,sum=0;
        int max=-1,min=-2;
        while(cur<len&&getDiff(sum,len-cur,arr[cur],target)<0){
            sum+= arr[cur++];
        }
        if(cur>=len){
            return arr[len-1];
        }
        min = cur == 0 ? 0: arr[cur-1];
        max = arr[cur];
        while(min<=max){
            int mid = (min + max) / 2;
            int diff = getDiff(sum,len-cur,mid,target);
            if(diff>=0){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return getSmaller(sum,len-cur,max,min,target);

    }

    private  int getDiff (int preSum,int count ,int val,int target){
        return preSum + count*val -target;
    }

    private int getSmaller(int preSum,int count ,int v1,int v2,int target){
        if(Math.abs(preSum + count*v1 -target)<=Math.abs(preSum + count*v2 -target)){
            return v1;
        }
        return v2;
    }
}
