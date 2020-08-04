package solution001_200;

public class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int len=Integer.MAX_VALUE;
        for(int i = 0 ; i< strs.length;i++){
            len = Math.min(len,strs[i].length());
        }
        int i=0;
        for(boolean flag = true; i<len;i++){
            for(int j=1;j<strs.length&&flag;j++){
                flag &= strs[j-1].charAt(i) == strs[j].charAt(i);
            }
            if(!flag){
                return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,i);
    }
}
