/**
 * @Author : Chad li
 * @Date : 2020/2/20 16:42
 * @Version 1.0
 */
public class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int left=0,right=1,total=1;right<=num;){
            if(left<0){
                left= right - 1;
                total++;
            }
            res[right++] = total -res[left--];
        }
        return res;
    }
    public int[] countBits1(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
