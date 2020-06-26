package interview;


public class Solution1618 {
    public boolean patternMatching(String pattern, String value) {
        char[] p = pattern.toCharArray();
        int plen = p.length, vlen = value.length();
        if(plen==0){
            return vlen==0;
        }
        int[] count = new int[]{0,0};
        for (char c : p) {
            count[c-'a']++;
        }
        if(count[0]==0||count[1]==0){
            if(vlen%plen==0){
                int len = vlen/plen;
                return isMatch(p,value,new int[]{count[0]==0?0:len,count[1]==0?0:len});
            }
            return false;
        }
        for(int lenA=0; lenA*count[0] <=value.length();lenA++){
            int lenB = (value.length() - lenA*count[0])/count[1];
            if((lenB*count[1] + lenA*count[1])==value.length()){
                if(isMatch(p,value,new int[]{lenA,lenB})){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMatch(char[] p, String v,int[] lens){
        String[] strs = new String[]{null,null};
        int cur = 0;
        for (char c : p) {
            int len = lens[c-'a'];
            String temp = v.substring(cur,cur + len);
            if(strs[c-'a']==null){
                strs[c-'a']=temp;
            }else{
                if(!strs[c-'a'].equals(temp)){
                    return false;
                }
            }
            cur += len;
        }
        return strs[0] == null || !strs[0].equals(strs[1]);
    }
}
