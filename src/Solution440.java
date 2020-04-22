/**
 * @Author : Chad li
 * @Date : 2020/4/21 11:45
 * @Version 1.0
 */
public class Solution440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while(k>0){
            int steps = calSteps(n, cur, cur+1);
            if(steps<=k){
                cur++;
                k -= steps;
            }else{
                cur*=10;
                k--;
            }
        }
        return cur;
    }

    private int calSteps(int n,long cur1, long cur2){
        int steps = 0;
        while(cur1<=n){
            steps += Math.min(cur2,n+1) - cur1;
            cur1*=10;
            cur2*=10;
        }
        return steps;
    }
}
