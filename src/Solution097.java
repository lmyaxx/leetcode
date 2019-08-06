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
}
