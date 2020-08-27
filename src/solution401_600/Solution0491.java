package solution401_600;

import java.util.*;

public class Solution0491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<LinkedList<Integer>>> map = new TreeMap<>();
        for(int i = 0; i< len;i++){
            List<LinkedList<Integer>> cur = new ArrayList<>();
            if(map.containsKey(nums[i])){
                List<LinkedList<Integer>> list = map.get(nums[i]);
                for(LinkedList<Integer> last: list){
                    cur.add(cloneAppend(last,nums[i]));
                }
            }
            Set<Integer> candidate = map.headMap(nums[i]).keySet();
            for(Integer one: candidate){
                List<LinkedList<Integer>> iter =  map.get(one);
                for(LinkedList<Integer> list: iter){
                    cur.add(cloneAppend(list,nums[i]));
                }
            }
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(nums[i]);
            cur.add(list);
            map.put(nums[i],cur);
        }
        for(Integer key: map.keySet()){
            for(LinkedList<Integer> list: map.get(key)){
                if(list.size()!=1){
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private LinkedList<Integer> cloneAppend(LinkedList<Integer> raw, Integer append){
        LinkedList<Integer> list  = (LinkedList<Integer>) raw.clone();
        list.addLast(append);
        return list;
    }
}
