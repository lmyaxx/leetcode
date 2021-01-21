package solution1401_1600;

import java.util.TreeMap;

public class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for(int num:arr){
            num = ((num % k) + k)%k;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            if((k-key)%k==key){
                if(map.get(key)%2!=0){
                    return false;
                }
            }else{
                if(map.get(k-key)==null|| !map.get(k - key).equals(map.get(key))){
                    return false;
                }
            }
        }
        return true;
    }
}
