import java.util.HashSet;

/**
 * @author: chad li
 * @date: 2021/1/23
 * @discription:
 */
public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] connection: connections){
            unionFind.union(connection[0],connection[1]);
        }
        return unionFind.getMinCount();
    }

    class UnionFind {
        int[] pre;
        int rest = 0;
        int count = 0;
        public UnionFind(int len){
            pre = new int[len];
            for (int i = 0; i < len; i++) {
                pre[i] = i;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                this.rest ++;
            }else{
                pre[rootY] = rootX;
            }
        }

        private int find(int x) {
            if(x != pre[x]){
                pre[x] = find(pre[x]);
            }
            return pre[x];
        }

        public int getMinCount(){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i< pre.length; i++){
                set.add(find(i));
            }
            int need = set.size()-1;
            return need > this.rest ? -1 : need;
        }
    }
}
