package solution201_400;

/**
 * @author: chad li
 * @date: 2021/2/4
 * @discription:
 */
public class Solution0357 {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        for(int i = 0; i<n; i++ ){
            ans += 9*combine(i);
        }
        return ans;
    }

    private int combine(int n){
        int product = 1, div = 1;
        for(int i = 0; i< n; i++){
            product *= 9 - i;
        }
        return product / div;
    }
}
