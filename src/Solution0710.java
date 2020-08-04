import java.util.HashMap;
import java.util.Random;

public class Solution0710 {

    HashMap<Integer,Integer> map;
    int size ;
    Random random;

    public Solution0710(int N, int[] blacklist) {
        size = N - blacklist.length;
        random = new Random();
        map = new HashMap<>();
        for(int black:blacklist){
            map.put(black,-1);
        }
        for(int black:blacklist){
            if(black<size){
                while(map.containsKey(N-1)){
                    N--;
                }
                map.put(black,N-1);
                N--;
            }
        }
    }

    public int pick() {
        int pos = random.nextInt(size);
        if(map.containsKey(pos)){
            return map.get(pos);
        }
        return pos;
    }
}