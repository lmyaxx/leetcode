package solution801_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chad li
 * @date: 2021/1/15
 * @discription:
 */
public class Solution0947 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for(int[] stone: stones){
            unionFind.union(stone[0], stone[1]+10001);
        }
        return stones.length - unionFind.getCount();
    }

    class UnionFind {
        private final Map<Integer,Integer> map;
        private int count;

        public UnionFind(){
            map = new HashMap<>();
            count = 0;
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            map.put(rootX,rootY);
            count--;
        }

        public int find(int x){
            if(!map.containsKey(x)){
                map.put(x,x);
                count++;
            }
            if(map.get(x) != x){
                map.put(x, find(map.get(x)));
            }
            return map.get(x);
        }

        public int getCount(){
            return count;
        }
    }
}
