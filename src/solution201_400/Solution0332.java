package solution201_400;

import java.util.*;

public class Solution0332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(List<String> iter: tickets){
            String from = iter.get(0);
            String to = iter.get(1);
            PriorityQueue<String> list = map.getOrDefault(from, new PriorityQueue<String>());
            list.add(to);
            map.put(from, list);
        }
        String from = "JFK";
        List<String> ans = new ArrayList<String>();
        dfs(from,map,ans);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String from, Map<String,PriorityQueue<String>> map, List<String> ans){
        while(map.containsKey(from)&&map.get(from).size()>0){
            String temp = map.get(from).poll();
            dfs(temp,map,ans);
        }
        ans.add(from);
    }

}
