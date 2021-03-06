package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/1/19 21:36
 * @Version 1.0
 */
public class Solution387 {
    public int firstUniqChar(String s) {
         int[] count = new int[26];
         for(int i=0;i<s.length();i++){
             count[s.charAt(i)-'a'] ++;
         }
         for(int i=0;i<s.length();i++){
             if(count[s.charAt(i)-'a']==1){
                 return i;
             }
         }
         return -1;
    }
}
