import org.junit.Test;

public class Solution009 {
    @Test
    public void test1(){

        System.out.println(Integer.MAX_VALUE);
    }
    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        int len = num.length();
        for(int left=0,right=len-1;left<right;left++,right--){
            if(num.charAt(left)!=num.charAt(right))
                return false;
        }
        return true;
    }
    /*----------------------第二种答案------------------------*/
    public boolean isPalindrome1(int x) {
        if(x<0)
            return false;
        return revert(x)==x;

    }
    //可能越界，但越界的一定不是回文Int型数字
    public int revert(int x){
        int ans=0;
        while(x>0){
            ans=ans*10 + x%10;
            x=x/10;
        }
        return ans;
    }
}
