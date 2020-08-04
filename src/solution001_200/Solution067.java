package solution001_200;

public class Solution067 {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()) return addBinary(b,a);
        int lenA =a.length()-1,lenB=b.length()-1;
        char result[] = new char[lenA+1];
        int extral = 0;
        while(lenB>=0){
            result[lenA] =(char) ((a.charAt(lenA)-'0'+b.charAt(lenB)-'0' + extral)%2+'0');
            extral = (a.charAt(lenA)-'0'+b.charAt(lenB)-'0' + extral)/2;
            lenA--;lenB--;
        }
        while(lenA>=0){
            result[lenA] =(char) ((a.charAt(lenA)-'0'+ extral)%2+'0');
            extral = (a.charAt(lenA)-'0'+ extral)/2;
            lenA--;
        }
        return (extral==0?"":"1")+String.valueOf(result);
    }
}
