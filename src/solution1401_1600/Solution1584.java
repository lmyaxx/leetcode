package solution1401_1600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: chad li
 * @date: 2021/1/21
 * @discription:
 */
public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j< len ; j ++){
                edges.add(new Edge(i,j, dist(i, j, points)));
            }
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a.dist));
        DisjointSetUnion union = new DisjointSetUnion(len);
        int ans = 0, count = 0;
        for(Edge edge: edges){
            if(union.union(edge.x,edge.y)){
                ans += edge.dist;
                count++;
            }
            if(count==len-1){
                return ans;
            }
        }
        return ans;
    }

    public int dist(int x, int y, int[][] points){
        return Math.abs(points[x][0]-points[y][0]) + Math.abs(points[x][1]-points[y][1]);
    }

    class DisjointSetUnion{
        int[] pre;
        public DisjointSetUnion(int len){
            pre = new int[len];
            for(int i = 0; i< pre.length ; i++){
                pre[i] = i;
            }
        }
        public boolean union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }
            pre[rootX] = rootY;
            return true;
        }
        public int find(int x){
            if(pre[x] != x){
                pre[x] = find(pre[x]);
            }
            return pre[x];
        }
    }

    class Edge {
        int x;
        int y;
        int dist;
        public Edge(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
