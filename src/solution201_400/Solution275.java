package solution201_400;

/**
 * @Author : Chad li
 * @Date : 2020/3/19 17:37
 * @Version 1.0
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        for(int i=0;i<citations.length;i++){
            int rest = citations.length  - i;
            if(rest<=citations[i]){
                return rest;
            }
        }
        return 0;
    }

    public int hIndex1(int[] citations) {
        int low=0, high = citations.length-1;
        int res = 0;
        while(low<=high){
            int mid = (low + high)/2;
            //int largeCount = citations.length-mid;
            //当有largeCount个元素大于等于citation[mid]
            //需要有largeCount个元素大与等于largeCount
            //mid向右移动，largeCount变小，citation[mid]变大
            //   向左移动，largeCount变大，citation[mid]变小
            // 要保持largeCount<=citation[mid],   最大的LargeCount为答案

            // largeCount<=citations[mid]时
            if(citations.length-mid<=citations[mid]){
                //满足条件时，使mid左移，看探测是否有更大的largeCount
                high = mid - 1;
            }else{
                //不满足条件时，则mid应当右移，看能否使之满足条件
                low = mid + 1;
            }
        }
        return citations.length - (high+1);
    }
}
