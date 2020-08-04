package solution201_400;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set =new HashSet<>();
        while (true){
            if(n==1)
                return true;
            if(set.contains(n))
                return false;
            set.add(n);
            int newN = 0;
            while(n>0){
                newN+=(n%10)*(n%10);
                n/=10;
            }
            n=newN;
        }
    }
}
