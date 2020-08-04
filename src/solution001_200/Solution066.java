package solution001_200;

public class Solution066 {
    public int[] plusOne(int[] digits) {
        int len=digits.length-1;
        int extral = (digits[len]+1)/10;
        digits[len] = (digits[len]+1)%10;
        for(len=len-1;len>=0&&extral!=0;len--){
            int newExtral = (digits[len] +extral)/10;
            digits[len] = (digits[len] +extral)%10;
            extral=newExtral;
        }
        if(extral==0){
            return digits;
        }else{
            int result[] = new int[digits.length+1];
            result[0]=extral;
//            for(int i=0;i<digits.length;i++)
//                result[i+1] = digits[i];
            return result;
        }
    }
}
