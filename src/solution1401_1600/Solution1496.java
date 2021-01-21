package solution1401_1600;

import java.util.HashSet;
import java.util.Set;

public class Solution1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        //start[0] = x, start[1] = y
        int[] start = {0,0};
        set.add("0,0");
        for(char ch:path.toCharArray()){
            if(ch=='N'){
                start[1] += 1;
            }
            if(ch=='W'){
                start[0] -= 1;
            }
            if(ch=='E'){
                start[0] += 1;
            }
            if(ch=='S'){
                start[1] -= 1;
            }
            String s = start[0] + "," + start[1];

            if(set.contains(s)){
                return true;
            }
            set.add(s);
        }

        return false;
    }
}
