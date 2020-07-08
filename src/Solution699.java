import java.util.*;

public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer,Integer> segment = new TreeMap<>();
        List<Integer> res = new ArrayList<>(positions.length);
        int max = 0;
        segment.put(0,0);
        for(int[] position:positions){
            int start = position[0], end = start + position[1];
            int last = segment.floorKey(start);
            int height = segment.subMap(last,end).values().stream().max(Integer::compare).get()+position[1];
            max = Math.max(max,height);
            res.add(max);
            int lastHeight = segment.floorEntry(end).getValue();
            segment.put(start,height);
            segment.put(end,lastHeight);
            segment.subMap(start, false, end, false).clear();
        }
        return res;
    }

    public List<Integer> fallingSquares1(int[][] positions) {
        Map<Integer,Integer> pos = getNewPositions(positions);
        SegementTree segementTree = new SegementTree(pos.size());
        List<Integer> res = new ArrayList<>(positions.length);
        int max = 0;
        for(int[] position:positions){
            int left = pos.get(position[0]);
            int right = pos.get(position[0]+position[1]-1);
            int height = segementTree.queryHeight(left,right) + position[1];
            max = Math.max(height,max);
            res.add(max);
            segementTree.updateHeight(left,right,height);
        }
        return res;
    }

    private HashMap<Integer, Integer> getNewPositions(int[][] positions){
        TreeSet<Integer> pos = new TreeSet<>();
        for(int[] position:positions){
            pos.add(position[0]);
            pos.add(position[0]+position[1] -1 );
        }
        HashMap<Integer,Integer> newPos = new HashMap<>(pos.size());
        int i = 0;
        for(int p:pos){
            newPos.put(p,i++);
        }
        return newPos;
    }

    class SegementTree{
        int[] nodes;
        int size;
        public SegementTree(int size){
            nodes = new int[1<<((int)(Math.ceil(Math.log(size)/Math.log(2)))+1)];
            this.size =  size;
        }

        public int queryHeight(int left, int right){
            return queryUtil(0,size-1,left,right,0);
        }

        private int queryUtil(int left,int right, int ql, int qr, int index){
            if(left>qr||right<ql){
                return 0;
            }
            if(ql<=left&&qr>=right){
                return nodes[index];
            }
            int mid = (left+right)/2;
            return Math.max(queryUtil(left,mid,ql,qr,2*index+1),queryUtil(mid+1,right,ql,qr,2*index+2));
        }

        public void updateHeight(int ul,int ur, int height) {
            updateUtil(0,size-1,ul,ur,0,height);
        }

        private void updateUtil(int left,int right, int ul, int ur, int index,int height){
            if(left>ur||right<ul){
                return;
            }
            if(left==right){
                nodes[index] = height;
            }
            int mid = (left+right) / 2;
            updateUtil(left,mid,ul,ur,2*index+1,height);
            updateUtil(mid+1,right,ul,ur,2*index+2,height);
            nodes[index] = Math.max(nodes[2*index+1],nodes[2*index+2]);
        }
    }
}
