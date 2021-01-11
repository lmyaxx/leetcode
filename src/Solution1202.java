import java.util.*;

/**
 * @author: chad li
 * @date: 2021/1/11
 * @discription:
 */
public class Solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] str = s.toCharArray();
        int len = str.length;
        UnionFind unionFind = new UnionFind(len);
        for(List<Integer> pair:pairs){
            int a = pair.get(0), b = pair.get(1);
            unionFind.union(a,b);
        }
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int root = unionFind.find(i);
            map.computeIfAbsent(root,key->new PriorityQueue<>()).offer(str[i]);
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < len ; i++){
            int root = unionFind.find(i);
            ans.append(map.get(root).poll());
        }
        return ans.toString();
    }

    class UnionFind {
        int[] parent;
        public UnionFind(int len){
            parent = new int[len];
            for(int i = 0; i< len; i++){
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if(rootX != rootY){
                parent[rootX] = rootY;
            }
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
