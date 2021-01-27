package solution1401_1600;

/**
 * @author: chad li
 * @date: 2021/1/27
 * @discription:
 */
public class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind common = new UnionFind(n);
        int ans = 0;
        for(int[] edge: edges){
            if(edge[0]==3){
                common.union(edge[1] - 1,edge[2] - 1);
            }
        }
        ans += common.getCount();
        UnionFind alice = new UnionFind(common.pre);
        UnionFind bob = new UnionFind(common.pre);
        for(int[] edge: edges){
            if(edge[0] == 1){
                alice.union(edge[1] - 1,edge[2] - 1);
            }
            if(edge[0] == 2){
                bob.union(edge[1] - 1,edge[2] - 1);
            }
        }
        int a = alice.find(0),b = bob.find(0);
        for(int i = 1; i < n; i++){
            if(a != alice.find(i) || b != bob.find(i)){
                return -1;
            }
        }
        ans += alice.getCount() + bob.getCount();
        return ans;
    }

    class UnionFind {
        int[] pre;
        int rest = 0;
        public UnionFind(int size){
            pre = new int[size];
            for(int i = 0; i < size; i++){
                pre[i] = i;
            }
        }

        public UnionFind(int[] copy){
            int len = copy.length;
            pre = new int[len];
            for(int i = 0; i < copy.length;i++ ){
                pre[i] = copy[i];
            }
        }

        public void union(int x, int y){
             int rootX = find(x);
             int rootY = find(y);
             if(rootX == rootY){
                 rest++;
             }else{
                 pre[rootX] = pre[rootY];
             }
        }

        public int find(int x){
            if(x != pre[x]){
                pre[x] = find(pre[x]);
            }
            return pre[x];
        }

        public int getCount(){
            return rest;
        }
    }
}
