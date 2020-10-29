public class Solution1208 {
    public int equalSubstring(String s, String t, int k) {
        int l = 0, r, len = s.length();
        for(r=0; r < len; r++){
            k -= Math.abs(s.charAt(r)-t.charAt(r));
            if(k<0){
                k += Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
        }
        return r - l;
    }
}
