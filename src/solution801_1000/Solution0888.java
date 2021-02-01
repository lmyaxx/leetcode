package solution801_1000;

import java.util.HashSet;

/**
 * @author: chad li
 * @date: 2021/2/1
 * @discription:
 */
public class Solution0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int sumB = 0, sumA = 0;
        for(int num : B){
            sumB += num;
            set.add(num);
        }
        for(int num : A){
            sumA += num;
        }
        int diff = sumA - sumB;
        for(int x : A){
            int y = x - diff / 2;
            if(set.contains(y)){
                return new int[]{x,y};
            }
        }
        return null;

    }
}
