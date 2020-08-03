package lcp;

import java.util.*;

public class Solution013 {
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,-1,0,1};
    int n, m;

    public int minimalSteps(String[] maze) {
        n = maze.length;
        m = maze[0].length();
        List<int[]> buttons = new ArrayList<>();
        List<int[]> stones = new ArrayList<>();
        int sx = -1, sy = -1, tx = -1, ty = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char  ch = maze[i].charAt(j);
                switch (ch){
                    case 'M': buttons.add(new int[]{i,j});break;
                    case 'O': stones.add(new int[]{i,j}); break;
                    case 'S': sx = i; sy = j; break;
                    case 'T': tx = i; ty = j; break;
                }
            }
        }
        int nb = buttons.size();
        int ns = stones.size();
        int[][] startDist = bfs(sx,sy,maze);
        //若没有障碍，起点到终点的最短长度
        if(nb == 0){
            return startDist[tx][ty];
        }
        // 机关到其他机关，到终点的最短距离，其中dist[i][nb+1] 是到终点dist[i][nb]是到起点
        int[][] dist = new int[nb][nb+2];
        for(int i = 0;i < nb; i++){
            Arrays.fill(dist[i],-1);
        }
        //中间结果，用于计算每个机关到其他所有点的最短距离
        int[][][] dd =  new int[nb][][];
        for(int i=0;i<nb;i++){
            int[][] d = bfs(buttons.get(i)[0],buttons.get(i)[1],maze);
            dd[i] = d;
            //某机关到终点不需拿石头
            dist[i][nb+1] = d[tx][ty];
        }
        for(int i = 0; i< nb; i++){
            int temp = -1;
            for(int k=0; k<ns; k++){
                int midX = stones.get(k)[0], midY = stones.get(k)[1];
                //机关i可达中间节点，起点可达中间节点
                if(dd[i][midX][midY]!=-1 && startDist[midX][midY]!=-1){
                    //求起点经过stone到机关i的最小路径长度
                    if(temp==-1||temp>dd[i][midX][midY]+startDist[midX][midY]){
                        temp = dd[i][midX][midY]+startDist[midX][midY];
                    }
                }
            }
            // 起点经过某个stone到i的最短距离
            dist[i][nb] = temp;
            for(int j= i+1; j< nb; j++){
                int mn = -1;
                for(int k=0;k<ns;k++){
                    int midX = stones.get(k)[0], midY = stones.get(k)[1];
                    // 机关i到stone,机关j到stone可达
                    if(dd[i][midX][midY]!= -1&& dd[j][midX][midY]!=-1){
                        if(mn==-1 || mn> dd[i][midX][midY] + dd[j][midX][midY]){
                            mn = dd[i][midX][midY] + dd[j][midX][midY];
                        }
                    }
                }
                dist[i][j] = mn;
                dist[j][i] = mn;
            }
        }
        //若有任意一点不可达终点和起点，则路径无法走通
        for(int i=0; i<nb; i++){
            if(dist[i][nb] == -1||dist[i][nb+1]==-1){
                return -1;
            }
        }
        //dp[i][j] 意味着当前位于j机关，而i中第几位是1，需要走的最少步数，则表示该机关已被破坏
        int[][] dp = new int[1<<nb][nb];
        for(int[] one:dp){
            Arrays.fill(one,-1);
        }
        //从起点到达第一个机关
        for(int i=0;i < nb; i++){
            dp[1<<i][i] = dist[i][nb];
        }
        for(int mask= 1; mask< (1<<nb); mask++){
            for(int i=0; i<nb;i++){
                //已经走到了i号机关
                if((mask&(1<<i))!=0){
                    for(int j =0 ; j<nb ; j++){
                        //还未到达过j号机关
                        if((mask&(1<<j))==0){
                            int next = mask|(1<<j);
                            if(dp[next][j]==-1||dp[next][j]>dp[mask][i] +  dist[i][j]){
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }
        //到此已经得到了走过所有机关dp[finalMask], 还需从最后的机关走到dp[]
        int res = -1;
        int finalMask = (1<<nb) -1;
        for(int i=0; i<nb;i++){
            if(res==-1||res>dp[finalMask][i] + dist[i][nb+1]){
                res = dp[finalMask][i] + dist[i][nb+1];
            }
        }
        return res;

    }
    public int[][] bfs(int x, int y, String[] maze) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ret[i], -1);
        }
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curx = p[0], cury = p[1];
            for (int k = 0; k < 4; k++) {
                int nx = curx + dx[k], ny = cury + dy[k];
                if (inBound(nx, ny) && maze[nx].charAt(ny) != '#' && ret[nx][ny] == -1) {
                    ret[nx][ny] = ret[curx][cury] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ret;
    }

    private boolean inBound(int x, int y){
        return !(x<0||y<0||x>=n||y>=m);
    }
}
