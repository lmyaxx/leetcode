package solution201_400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution279 {

    //bfs
    public int numSquares(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int res = 0;
        while(true){
            Set<Integer> temp = new HashSet<>();
            res++;
            for(Integer num:set){
                if(isSquare(num))
                    return res;
                else{
                    helper(num,temp);
                }
            }
            set = temp;
        }
    }

    private void helper(int n,Set<Integer> temp){
        for(int i=1;i*i<n;i++){
            temp.add(n-i*i);
        }
    }

    private boolean isSquare(int n){
        int root = (int)Math.sqrt(n);
        return n==root*root;
    }
}
