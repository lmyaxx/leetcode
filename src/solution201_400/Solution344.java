package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/1/10 20:07
 * @Version 1.0
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left=0,right = s.length-1;
        while(left<right){
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left++] ^=s[right--];
        }
    }
}
