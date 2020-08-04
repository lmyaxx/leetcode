package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/3/19 12:37
 * @Version 1.0
 */
public class Solution273 {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String[] nums1 = new String[]{"One","Two","Three","Tour","Five","Six","Seven","Eight","Nine"};
        String[] nums2 = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] nums3 = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String res = "",temp;
        String[] matrix = new String[]{"Billion","Million","Thousand",""};
        for(int i=0,size=1000000000;i<4;i++){
            String str = getWordUnder1000(num/size,nums1,nums2,nums3);
            if(!"".equals(str)){
                res+= str + " " + matrix[i];
            }
            num%=size;
            size/=1000;
        }
        return res;
    }

    private String getWordUnder1000(int num,String[] nums1,String[] nums2, String[] nums3){
        String res = "";
        if(num/100!=0){
            res+= nums1[num/100-1]+" Hundred";
        }
        num %= 100;
        if(num/10==1){
            res += " " + nums2[num%10];
            return res;
        }
        if(num/10>1){
            res += " " + nums2[num/10-2];
        }
        num %=10;
        if(num!=0){
            res += " " +nums1[num-1];
        }
        return res.trim();
    }
}
