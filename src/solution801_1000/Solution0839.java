package solution801_1000;

/**
 * @author: chad li
 * @date: 2021/1/31
 * @discription:
 */
public class Solution0839 {
    class UnionFind {
        int[] pre;
        public UnionFind(int len){
            pre = new int[len];
            for (int i = 0; i < len; i++) {
                pre[i] = i;
            }
        }

        public void union(int i, int j){
            int rootX = find(i);
            int rootY = find(j);
            if(rootX != rootY){
                pre[rootY] = rootX;
            }
        }

        public int find(int x){
            if(pre[x] != x){
                pre[x] = find(pre[x]);
            }
            return pre[x];
        }

        private int getCount(){
            int ans = 0;
            for (int i = 0; i < pre.length; i++) {
                if(pre[i] == i){
                    ans++;
                }
            }
            return ans;
        }

    }


    public int numSimilarGroups(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if(isConnected(strs[i],strs[j])){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }




    private boolean isConnected(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count>=3){
                    return false;
                }
            }
        }
        return true;
    }
}
