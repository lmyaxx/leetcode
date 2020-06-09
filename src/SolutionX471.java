import java.util.Arrays;

public class SolutionX471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = (arr.length - 1) / 2;
        int left = 0, right = arr.length-1;
        int[] res = new int[k];
        while(k-->0){
            if(Math.abs(arr[right]-arr[mid])>=Math.abs(arr[left]-arr[mid])){
                res[k] = arr[right];
                right--;
            }else{
                res[k] = arr[left];
                left++;
            }
        }
        return res;
    }
}
