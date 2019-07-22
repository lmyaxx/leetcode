public class Solution058 {
    public int lengthOfLastWord(String s) {
        int end=s.length()-1;
        while(end>=0&&s.charAt(end)==' ') end--;
        int len=end;
        while(len>=0){
            if(s.charAt(len)==' ')
                break;
            len--;
        }
        return end-len;
    }
}
