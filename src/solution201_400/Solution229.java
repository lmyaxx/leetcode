package solution201_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/15 8:44
 * @Version 1.0
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length<1){
            return res;
        }
        int count1=0,count2=0,num1=0,num2=1;
        for(int num:nums){
            if(num==num1){
                count1++;
                continue;
            }
            if(num==num2){
                count2++;
                continue;
            }
            if(count1==0){
                num1 = num;
                count1=1;
                continue;
            }
            if(count2==0){
                num2 = num;
                count2 =  1;
                continue;
            }
            count1--;
            count2--;
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==num1){
                count1++;
            }else if(num==num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            res.add(num1);
        }
        if(count2>nums.length/3){
            res.add(num2);
        }
        return res;
    }
}
