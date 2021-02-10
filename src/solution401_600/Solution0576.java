package solution401_600;

/**
 * @author: chad li
 * @date: 2021/2/10
 * @discription:
 */
public class Solution0576 {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int total = s1.length();
        int left = 0, right = 0;
        for(char ch: s1.toCharArray()){
            count[ch - 'a'] ++;
        }
        while(right < s2.length()){
            char ch = s2.charAt(right);
            count[ch - 'a']--;
            total --;
            while(count[ch-'a'] < 0){
                char c = s2.charAt(left);
                count[c - 'a']++;
                total++;
                left++;
            }
            if(total == 0){
                return true;
            }
            right++;
        }
        return false;
    }
}
