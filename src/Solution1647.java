import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1647 {
    public int minDeletions(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char ch: s.toCharArray()){
            count.put(ch, count.getOrDefault(ch,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int len: count.values()){
            pq.offer(len);
        }
        int ans = 0;
        if(pq.size() !=0 ) {
            int level = pq.peek();
            while (!pq.isEmpty()) {
                int cur = pq.poll();
                if (cur >= level) {
                    ans += cur - level;
                } else {
                    level = cur;
                }
                level = level == 0 ? 0 : level - 1;
            }
        }
        return ans;
    }
}
