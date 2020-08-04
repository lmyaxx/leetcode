package solution401_600;

import java.util.*;

/**
 * @Author : Chad li
 * @Date : 2020/2/23 14:59
 * @Version 1.0
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        List<Integer> pos = new LinkedList<Integer>();
        for(int i=0;i<people.length;i++){
            pos.add(i);
        }
        int[][] res = new int[people.length][];
        for(int i=0;i<people.length;i++){
            int index = pos.get(people[i][1]);
            res[index] = people[i];
            pos.remove(people[i][1]);
        }
        return res;
    }

    public int[][] reconstructQueue1(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
