public class Solution125 {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for(int i=0,j=actual.length()-1;i<j;i++,j--){
            if(actual.charAt(i)!=actual.charAt(j))
                return false;
        }
        return true;
    }
}
