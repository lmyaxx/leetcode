import java.util.Comparator;
import java.util.TreeSet;

public class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = new int[]{0,0};
        int[] can2 = new int[]{0,0};
        int[] parent = new int[edges.length+1];
        for(int[] edge:edges){
            if(parent[edge[1]]!=0){
                can1 = new int[]{edge[0],edge[1]};
                can2 = new int[]{parent[edge[1]],edge[1]};
                edge[1] = 0;
            }else{
                parent[edge[1]] = edge[0];
            }
        }
        for(int i=0;i<=edges.length;i++){
            parent[i] = i;
        }
        for(int[] edge:edges){
            int p = edge[0],c = edge[1];
            if(c==0){
                continue;
            }

            if(root(parent,p)==c){
                //there is a circle
                if(can1[0]!=0){
                    return can2;
                }else{
                    return edge;
                }

            }
            parent[c] = p;
        }
        return can1;
    }

    private int root(int[] parent, int child){
        while(child!=parent[child]){
            child = parent[child];
        }
        return child;
    }
}
