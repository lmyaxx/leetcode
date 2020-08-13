package solution601_800;

public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n + 1;

        while(low <= high){
            int mid = (low+high)/2;
            if(count(mid,m,n)>=k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return high + 1;
    }

    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count += temp;
        }
        return count;
    }
}
