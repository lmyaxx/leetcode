public class Solution072 {
    public int minDistance(String word1, String word2) {
        int memo[][] = new int[word1.length()][word2.length()];
        return helper(0,0,word1,word2,memo);
    }
    // horse
    // asdfsdfsdd
    public int helper(int one,int two,String word1,String word2,int [][] memo){
        if(one==word1.length()) return word2.length()-two;
        if(two==word2.length()) return word1.length()-one;
        if(memo[one][two]>0) return memo[one][two];
        int result= 0;
        if(word1.charAt(one)==word2.charAt(two))
            return helper(one+1,two+1,word1,word2,memo);
        else{
                                    //replace                                   //delete
            result = Math.min(helper(one+1,two+1,word1,word2,memo), helper(one+1,two,word1,word2,memo));
                                        // insert  nc  ntc
            result = Math.min(result,helper(one,two+1,word1,word2,memo));
        }
        return memo[one][two] = (result+1);
    }

    public int minDistance1(String word1, String word2) {
        int len1 = word1.length(),len2 = word2.length();
        //memo[i][j] means the minDistances of (word1[0:i], word2[0:j])
        int memo[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++) memo[i][0] = i;
        for(int j=0;j<=len2;j++) memo[0][j] = j;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                }else{
//                                         replace                 remove         insert
                    //                     ab  ac                  at  a          a  at
                    memo[i][j] = Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]))+1;
                }
            }
        }
        return memo[len1][len2];
    }
}
