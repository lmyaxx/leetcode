import java.util.*;

public class Solution1632 {

    int[] father;
    int rows, cols, len;
    int[] rowStore, colStore;
    public int[][] matrixRankTransform(int[][] matrix) {
        rows = matrix.length; cols = matrix[0].length; len = rows * cols;
        father = new int[len];
        rowStore = new int[rows];
        colStore = new int[cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
        for(int i = 0;i < rows; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j =0 ; j <cols; j++){
                int mask = i*cols + j, num = matrix[i][j];
                father[mask] = mask;
                if(map.containsKey(num)){
                    int x = map.get(num), y = mask;
                    if(findFather(x) != findFather(y)){
                        union(x,y);
                    }
                }else{
                    map.put(num, mask);
                }
                pq.add(new int[]{i,j});
            }
        }

        for (int j = 0; j < cols; j++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                int mask = i*cols + j, num = matrix[i][j];
                if(map.containsKey(num)){
                    int x = map.get(num), y = mask;
                    if(findFather(x) != findFather(y)){
                        union(x,y);
                    }
                }else{
                    map.put(num, mask);
                }
            }
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i< len; i++){
            int pos = findFather(i);
            if(!map.containsKey(pos)){
                map.put(pos,new HashSet<>());
            }
            map.get(pos).add(i);
        }
        for(Integer key : map.keySet()){
            if(map.get(key).size()!=1){
                int r = key / cols;
                int c = key % cols;
                System.out.println(key + "  " + matrix[r][c] + "  " + map.get(key).toString());
            }
        }
        int[][] ans = new int[rows][cols];
        HashSet<Integer> done = new HashSet<>();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            int k = r * cols + c;
            int pos = findFather(k);
            if(done.contains(pos)){
                continue;
            }else{
                done.add(pos);
            }
            HashSet<Integer> set = map.get(pos);
            int max = Integer.MIN_VALUE;
            for(Integer i : set){
                r = i / cols;
                c = i % cols;
                int temp = Math.max(rowStore[r],colStore[c]);
                max = Math.max(temp, max);
            }
            max ++;
            for(Integer i : set){
                r = i / cols;
                c = i % cols;
                ans[r][c] = max;
                rowStore[r] = colStore[c] = max;
            }
        }
        return ans;
    }


    private void union(int x, int y){
        x = father[x];
        y = father[y];
        if(x < y){
            father[y] = x;
        }else{
            father[x] = y;
        }
    }

    private int findFather(int k){
        if(father[k] != k){
            father[k] = findFather(father[k]);
        }
        return father[k];
    }
}
