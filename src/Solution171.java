public class Solution171 {
    public int titleToNumber(String s) {
        if(s.length()==0)return 0;
        int res=s.charAt(0)-'A'+1;
        for(int i=1;i<s.length();i++){
            res = res*26 + s.charAt(i)-'A'+1;
        }
        return res;
    }
}
