package solution801_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chad li
 * @date: 2021/1/31
 * @discription:
 */
public class Solution0989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int rest = 0;
        for(int i = A.length - 1; i>=0; i--){
            A[i] += K % 10 + rest;
            rest = A[i] / 10;
            A[i] %= 10;
            K /= 10;
        }
        List<Integer> ans = new ArrayList<>(A.length + 1);
        rest += K;
        if(rest > 0){
            for(char ch :String.valueOf(rest).toCharArray()){
                ans.add(ch - '0');
            }

        }

        for(int num: A){
            ans.add(num);
        }
        return ans;
    }
}
