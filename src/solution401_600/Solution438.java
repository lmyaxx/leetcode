package solution401_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Chad li
 * @Date : 2020/2/26 19:41
 * @Version 1.0
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> rs = new HashMap<>();
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
            rs.put(p.charAt(i),rs.getOrDefault(p.charAt(i),0)+1);
        }
        int tail=0, head =0;
        char ch,ct;
        while(true){
            if(head>=s.length()){
                break;
            }
            ch = s.charAt(head);
            if(!map.containsKey(ch)){
                restore(map,rs);
                tail = ++head;
                count = p.length();
                continue;
            }
            if(map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
                count--;
            } else{
                while(s.charAt(tail)!= ch){
                    map.put(s.charAt(tail),map.get(s.charAt(tail)) +1);
                    tail++;
                    count++;
                }
                tail++;
            }
            if(count==0){
                result.add(tail);
                ct = s.charAt(tail);
                tail++;
                count++;
                map.put(ct,map.get(ct) + 1);
            }
            head++;
        }
        return result;
    }

    private void restore(Map<Character,Integer> map,Map<Character,Integer> rs){
        for(Character ch: map.keySet()){
            map.put(ch,rs.get(ch));
        }
    }
}
