public class Solution7 {
    public int reverse(int x) {
        int result=0;
        while(x!=0){
            int rest = x %10;
            int  newResult = result * 10 + rest;
            if((newResult - rest)/10 != result)
                return 0;
            x/=10;
            result = newResult;
        }
        return result;
    }
}
