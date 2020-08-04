package solution001_200;

import org.junit.Test;

public class Solution008 {
    @Test
    public void test1(){
        System.out.println(myAtoi("2147483648"));
        System.out.println(Integer.MAX_VALUE);
    }
    public int myAtoi(String str) {
        int result=0;
        char ch;
        int posOrNeg = 1;
        str = str.trim();
        int len=str.length();
        int i =0;
        if(len>1){
            ch=str.charAt(0);
            if(ch=='-'){
                posOrNeg=-1;
                i++;
            }
            if(ch=='+'){
                i++;
            }
        }

        for( ;i<len;i++){
            ch =str.charAt(i);
            if(ch<='9'&&ch>='0'){
                int newResult = result*10+(ch-'0');
                if(newResult<0||(newResult-(ch - '0'))/10 !=result)
                    return posOrNeg ==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else{
                    result = newResult;
                }
            }else{
                break;
            }

        }
        return result*posOrNeg;
    }
}
