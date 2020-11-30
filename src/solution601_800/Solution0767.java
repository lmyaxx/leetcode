package solution601_800;

import java.util.*;

public class Solution0767 {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for(char ch: S.toCharArray()){
            count[ch - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int i = 0 ; i< 26; i++){
            if(count[i]>0){
                pq.offer(new int[]{count[i],i});
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(pq.isEmpty()){
                if(first[0]>1){
                    return "";
                }else{
                    sb.append((char)('a' + first[1]));
                    break;
                }
            }
            int[] second = pq.poll();
            sb.append((char)('a' + first[1]));
            sb.append((char)('a' + second[1]));
            first[0]--;
            second[0]--;
            if(first[0]>0){
                pq.offer(first);
            }
            if(second[0]>0){
                pq.offer(second);
            }
        }
        return sb.toString();
    }
}
