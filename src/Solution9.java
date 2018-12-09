import org.junit.Test;

public class Solution9 {
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
}
