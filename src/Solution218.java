import java.util.*;

public class Solution218 {

    // solution will encounter indexOutOfBound
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int [] ground = new int[10002];
        for(int []building :buildings){
            for(int i=building[0];i<=building[1];i++){
                ground[i] = Math.max(building[2],ground[i]);
            }
        }
        int left = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<ground.length;i++){
            if(ground[i]==left) continue;
            if(ground[i]!=left){
                if(ground[i]>left){
                    res.add(Arrays.asList(i,ground[i]));
                }else {
                    res.add(Arrays.asList(i-1,ground[i]));
                }
                left=ground[i];
            }
        }
        return res;
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        List<List<Integer>> result = new LinkedList<>();
        List<int []> heights = new ArrayList<>();
        for(int []b :buildings){
            heights.add(new int[]{b[0],-b[2]});  // use negative number to store the begin
            heights.add(new int[]{b[1],b[2]}); // use positive number to store the end
        }
        Collections.sort(heights,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);  // make the begin and end in order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));  // big bottom heap
        pq.add(0);
        int preMax = 0;
        for(int num[]:heights){
            if(num[1]<0){
                pq.add(-num[1]);  // add the height of a new building
            }else{
                pq.remove(num[1]);  //remove a build
            }
            int cur_max = pq.peek();
            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if(cur_max!=preMax){
                result.add(Arrays.asList(num[0],cur_max));
                preMax = cur_max;
            }
        }
        return result;
    }
}
