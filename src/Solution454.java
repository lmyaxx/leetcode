import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/2/5 9:28
 * @Version 1.0
 */
public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int [] sumOfAB = new int[A.length*B.length];
        int [] sumOfCD = new int[C.length*D.length];
        int count = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                sumOfAB[count++]=A[i] + B[j];
            }
        }
        count = 0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                sumOfCD[count++]=C[i] + D[j];
            }
        }
        Arrays.sort(sumOfAB);
        Arrays.sort(sumOfCD);
        int left = 0, right = sumOfCD.length-1;
        count = 0;
        while(left<sumOfAB.length&&right>=0){
            if(sumOfAB[left] + sumOfCD[right]>0){
                right--;
            } else if(sumOfAB[left] + sumOfCD[right]<0){
                left++;
            } else{
                left++;right--;
                int countAB = 1,countCD = 1;
                while(left<sumOfAB.length&&sumOfAB[left-1]==sumOfAB[left]) {
                    countAB++;
                    left++;
                }
                while(right>=0&&sumOfCD[right+1]==sumOfCD[right]){
                    countCD++;
                    right--;
                }
                count += countAB*countCD;
            }
        }
        return count;
    }
}
