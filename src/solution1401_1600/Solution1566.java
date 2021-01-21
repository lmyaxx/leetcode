package solution1401_1600;

public class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length, count = 0, total = m * k;
        for(int i=0; i + m < len; i++ ){
            if(arr[i]!=arr[i+m]){
                count = 0;
            }else {
                count ++;
                if(count>=total-m){
                    return true;
                }
            }
        }
        return false;
    }
}
