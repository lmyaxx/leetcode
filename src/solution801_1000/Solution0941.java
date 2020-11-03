package solution801_1000;

public class Solution0941 {
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int len = A.length, lmax = 0, rmax = A.length - 1;
        for(int i = 1; i < len ;i++){
            if(A[i]>A[lmax]){
                lmax = i;
            }else{
                break;
            }
        }
        for(int i = len - 2; i>=0; i--){
            if(A[i]>A[rmax]){
                rmax = i;
            }else{
                break;
            }
        }
        return lmax == rmax && lmax != 0 && lmax != len -1;
    }
}
