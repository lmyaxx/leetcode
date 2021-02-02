package solution401_600;

/**
 * @author: chad li
 * @date: 2021/2/2
 * @discription:
 */
public class Solution0424 {
    public int characterReplacement(String s, int k) {
        if(s.length()<2){
            return s.length();
        }
        char[] str = s.toCharArray();
        int[] fre = new int[26];
        int left = 0, right = 0, maxCount = 0;
        while(right<str.length){
            fre[str[right] - 'A']++;
            maxCount = Math.max(maxCount, fre[str[right]-'A']);
            right ++;
            if(right - left > maxCount + k){
                fre[str[left]-'A']--;
                left ++;
            }
        }
        return right - left;
    }
}
