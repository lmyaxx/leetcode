package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/3/21 11:05
 * @Version 1.0
 */
public class Solution299 {
    public String getHint(String secret, String guess) {
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];
        int A = 0,B = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                A++;
            }else{
                countSecret[secret.charAt(i)-'0']++;
                countGuess[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            B+=Math.min(countGuess[i],countSecret[i]);
        }
        return A+"A"+B+"B";
    }
}
