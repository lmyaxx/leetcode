package solution201_400;

import java.util.Arrays;

/**
 * @Author : Chad li
 * @Date : 2020/3/19 16:36
 * @Version 1.0
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for(int i=0;i<citations.length;i++){
           int rest = citations.length  - i;
           if(rest<=citations[i]){
               res = Math.max(rest,res);
           }
        }
        return res;
    }
    public int hIndex1(int[] citations) {
        int len = citations.length;
        int[] count = new int[citations.length+1];
        for(int num:citations){
            if(num>len){
                count[len]++;
            }else{
                count[num]++;
            }
        }
        int total = 0;
        int res=0;
        for(int i=len;i>=0;i--){
            total+=count[i];
            if(total>=i){
                res=i;
                break;
            }
        }
        return res;
    }
}
