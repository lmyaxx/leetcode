package solution001_200;

public class Solution043 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(),len2=num2.length(),len3=len1+len2;
        if(num1.equals("0")|| num2.equals("0"))
            return "0";
        char [] result = new char[len3];
        for(int i=0;i<len3;i++){
            result[i]='0';
        }
        for(int i=len2-1;i>=0;i--){
            for(int j=len1-1;j>=0;j--){
                int mul = (num1.charAt(j)-'0')*(num2.charAt(i)-'0')+(result[i+j+1]-'0');
                result[i+j+1] = (char)('0'+(mul%10));
                result[i+j] = (char)(result[i+j]+(mul)/10);
            }
        }
        if(result[0]=='0')
            return String.valueOf(result).substring(1);
        else
            return String.valueOf(result);
    }
}
