public class Solution1545 {
    public char findKthBit(int n, int k) {
        int round = 1, len = 1;
        while(len<k){
            len = len*2 + 1;
        }
        boolean isChange = false;
        while(true){
            int mid = len / 2 + 1;
            if(k == mid){
                // change: 1 , not change : 0
                if(mid==1){
                    return isChange ? '1' : '0';
                }else{
                    return isChange ? '0' : '1';
                }
            }else if( k > mid){
                k = mid - (k -mid);
                isChange = !isChange;
            }
            len = mid - 1;
        }
    }
}
