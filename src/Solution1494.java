import java.util.*;

public class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] out = new int[n+1];
        int[] heights = new int[n+1];
        List<Integer>[] adj = new List[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] dp:dependencies){
            out[dp[0]] ++;
            adj[dp[1]].add(dp[0]);
        }
        for(int i = 1; i <= n; i++ ){
            if(out[i]==0){
                getHeight(heights,adj,i);
            }
        }

        int ans = 0;
        while(n>0){
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> heights[b] - heights[a]);
            for(int i = 1; i<out.length; i++){
                if(out[i]==0){
                    queue.add(i);
                }
            }
            int remove = Math.min(k,queue.size());
            n -= remove;
            for(int i=0;i<remove;i++){
                int root = queue.poll();
                // 移除当前课程
                out[root] = -1;
                for(int pre:adj[root]){
                    // 其前驱的出度-1
                    out[pre]--;
                }
            }
            ans ++;
        }
        return ans;
    }

    private void getHeight(int[] height, List<Integer>[] adj,int root){
        for(int pre:adj[root]){
            getHeight(height,adj,pre);
            height[root] = Math.max(height[root],height[pre] + 1);
        }
    }

    public int minNumberOfSemesters1(int n, int[][] dependencies, int k) {
        int[] pre = new int[n];
        for(int[] d:dependencies){
            d[0]--;
            d[1]--;
            pre[d[1]] |= 1<<d[0];
        }
        int all = 1<<n;
        int[] dp = new int[all];
        for(int i=1;i<all;i++){
            dp[i] = n;
        }
        for(int state = 0; state < all; state++){
            //在修课状态为state，可以修的课
            int next = 0;
            for(int i=0;i<n;i++){
                if((state&pre[i])==pre[i]){
                    next |= 1<< i;
                }
            }
            //没修的课
            next &= ~state;
            //sub = (sub - 1)&next 会遍历 next全部子集
            for(int sub = next;sub >0 ;sub = (sub - 1)&next){
                if(Integer.bitCount(sub)<=k){
                    dp[state|sub] = Math.min(dp[state|sub],dp[state] + 1);
                }
            }
        }
        return dp[all-1];
    }

}
