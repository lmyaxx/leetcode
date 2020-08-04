package solution001_200;

public class Solution070 {
    public int climbStairs(int n) {
        if(n<3) return n;
        int one=1,two=2,temp;
        while(n-->2){
            temp = two+one;
            one=two;
            two=temp;
        }
        return two;
    }
}
