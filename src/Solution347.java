import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/1/10 20:31
 * @Version 1.0
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        List<Integer> result = new LinkedList<>();
        for(Map.Entry<Integer,Integer> pair: map.entrySet()){
            queue.offer(pair);
            if(queue.size()>k){
                queue.poll();
            }
        }
        while(!queue.isEmpty()){
            result.add(0,queue.poll().getKey());
        }
        return result;
    }
}
