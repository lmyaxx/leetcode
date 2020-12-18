package solution201_400;

/**
 * @author: chad li
 * @date: 2020/12/18
 * @discription:
 */
public class Solution0389 {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            count[ch - 'a']--;
        }
        for(char ch = 'a'; ch <= 'z'; ch ++){
            if(count[ch-'a']==-1){
                return ch;
            }
        }
        return 'a';
    }
}
