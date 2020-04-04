import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author : Chad li
 * @Date : 2020/4/3 17:06
 * @Version 1.0
 */
public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int width = matrix[0].length,height = matrix.length;
        int[] list = new int[width];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<height;i++){
            Arrays.fill(list,0);
            for(int j=i;j<height;j++){
                for(int n=0;n<width;n++){
                    list[n] += matrix[j][n];
                }
                ans = Math.max(ans,getMaxSumSub(list,k));
            }
        }
        return ans;
    }

    private int getMaxSumSub(int[] list,int k){
        TreeSet<Integer> treeSet = new TreeSet<>();
        int best=Integer.MIN_VALUE,sum = 0;
        treeSet.add(0);
        for(int num:list){
            sum += num;
            //k+1>sum-former->k>=sum-former
            Integer former = treeSet.higher(sum-k-1);
            if(former!=null){
                best = Math.max(best,sum-former);
            }
            treeSet.add(sum);
        }
        return best;
    }
}
