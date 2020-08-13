package solution601_800;

public class Solution0696 {
    public int countBinarySubstrings(String s) {
        int res = 0, i =0;
        int count1 = 0, count2=0;
        char last= '0';
        if(s.charAt(0)=='0'){
            last = '1';
        }
        while(i<s.length()){
            while(i<s.length()&&s.charAt(i) != last){
                i++;
                count1++;
            }
            res += Math.min(count1,count2);
            count2 = count1;
            count1 = 0;
            if(last=='0'){
                last = '1';
            }else{
                last = '0';
            }
        }
        return res;
    }
}
