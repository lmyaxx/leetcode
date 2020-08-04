package solution001_200;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                String normal = a+b;
                String reverse = b+a;
                return reverse.compareTo(normal);
            }
        });
        if(strs.length>0&&strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s);
        }
        return sb.toString();
    }
}
