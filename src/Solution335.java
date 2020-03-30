/**
 * @Author : Chad li
 * @Date : 2020/3/30 20:43
 * @Version 1.0
 */
public class Solution335 {
    public boolean isSelfCrossing(int[] x) {
        for(int i =3;i<x.length;i++){
            if(x[i]>=x[i-2]&&x[i-1]<=x[i-3]){
                return true;
            }
            if(i>=4&&x[i]+x[i-4]>=x[i-2]&&x[i-1]==x[i-3]){
                return true;
            }
            if(i>=5&&x[i]+x[i-4]>=x[i-2]&&x[i-1]+x[i-5]>=x[i-3]&&x[i-1]<=x[i-3]&&x[i-2]>=x[i-4]){
                return true;
            }
        }
        return false;
    }
}
