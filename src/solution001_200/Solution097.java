package solution001_200;

public class Solution097 {

    public boolean isInterleave(String s1, String s2, String s3) {
//        s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//               i             j
        if(s1.length()+s2.length()!=s3.length()) return false;
        if(s1.length()<s2.length()) return isInterleave(s2,s1,s3);
        boolean cut[] = new boolean[s3.length()+1];
        boolean judge[][] = new boolean[s1.length()+1][s2.length()+1];
        judge[0][0] =true;cut[0]=true;
        for(int i=1;i<=s1.length()&& s1.charAt(i-1)==s3.charAt(i-1);i++){
            judge[i][0]=true;
            cut[i]=true;
        }
        for(int i=1;i<=s2.length()&& s2.charAt(i-1)==s3.charAt(i-1);i++){
            judge[0][i]=true;
            cut[i]=true;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)&&judge[i-1][j]||s2.charAt(j-1)==s3.charAt(i+j-1)&&judge[i][j-1]){
                    judge[i][j]=true;
                    cut[i+j]=true;
                }
            }
            if(!cut[i])
                return false;
        }
        return judge[s1.length()][s2.length()];
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        char[] sb1 = s1.toCharArray();
        char[] sb2 = s2.toCharArray();
        char[] sb3 = s3.toCharArray();
        int[] count = new int[26];
        for(char ch: sb1){
            count[ch-'a']++;
        }
        for(char ch:sb2){
            count[ch-'a']++;
        }
        for(char ch:sb3){
            count[ch-'a']--;
        }
        for(int c:count){
            if(c!=0){
                return false;
            }
        }
        int[][] memo = new int[sb1.length+1][sb2.length+1];
        return helper(sb1,sb2,sb3,0,0,0,memo);
    }

    private boolean helper(char[] sb1,char[] sb2,char[] sb3, int i, int j, int k,int[][] memo){
        if(memo[i][j]!=0){
            return memo[i][j] == 1;
        }
        while(i>=sb1.length||j>=sb2.length||sb1[i]!=sb2[j]){
            if(i<sb1.length&&sb1[i]==sb3[k]){
                i++;k++;
            }else if(j<sb2.length&&sb2[j] == sb3[k]){
                j++;k++;
            }else{
                if(k == sb3.length){
                    return true;
                }else{
                    return false;
                }
            }
        }
        if(sb1[i]!=sb3[k]){
            memo[i][j]=-1;
            return false;
        }
        if(helper(sb1,sb2,sb3, i+1, j, k+1,memo)){
            memo[i+1][j] = 1;
            return true;
        }else{
            memo[i+1][j] = -1;
        }
        return  helper(sb1,sb2,sb3, i+1, j, k+1,memo)|| helper(sb1,sb2,sb3, i, j+1, k+1,memo);
    }
}
