package solution001_200;

public class Solution168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while((n-1)>=0){
            sb.insert(0,(char)('A'+(n-1)%26));
            n=(n-1)/26;
        }
        return sb.toString();
    }
}
