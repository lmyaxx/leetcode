import java.util.Arrays;

public class Solution087 {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] letters = new int[26];
        int len = s1.length();
        for (int i=0; i<len; i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
        for(int i=1;i<len;i++){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            if(isScramble(s11,s21)&&isScramble(s12,s22)) return true;
            s21 = s2.substring(len-i);
            s22 = s2.substring(0,len-i);
            if(isScramble(s11,s21)&&isScramble(s12,s22)) return true;
        }
        return false;
    }

    public boolean isScramble1(String s1, String s2) {
        int[] letters = new int[26];
        int len = s1.length();
        for (int i=0; i<len; i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
        boolean [][][]memo = new boolean[len][len][len+1];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                memo[i][j][1]= s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int i=2;i<=len;i++){
            for(int m=0;m<=len-i;m++){
                for(int n=0;n<=len-i;n++){
                    for(int k=1;k<i;k++){
                        if(memo[m][n][k]&&memo[m+k][n+k][i-k]||memo[m][n+i-k][k]&&memo[m+k][n][i-k])
                            memo[m][n][i]=true;
                    }
                }
            }
        }
        return memo[0][0][len];
    }

}
