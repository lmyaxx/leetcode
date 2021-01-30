import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: chad li
 * @date: 2021/1/30
 * @discription:
 */
public class Solution1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int[] count = new int[n];
        int num = languages.length;
        Set<Integer>[] sets = new Set[num];
        for (int i = 0; i < num; i++) {
            sets[i] = Arrays.stream(languages[i]).boxed().collect(Collectors.toSet());
        }
        boolean[] visited = new boolean[num];
        int people = 0;
        for(int[] friendship: friendships){
            int a = friendship[0]-1, b = friendship[1]-1;
            if(!canCommunicate(a,b,sets)){
                if(!visited[a]){
                    for(int l : languages[a]){
                        count[l-1]++;
                    }
                    visited[a] = true;
                    people++;
                }
                if(!visited[b]){
                    for(int l : languages[b]){
                        count[l-1]++;
                    }
                    visited[b] = true;
                    people++;
                }

            }
        }
        int max = 0;
        for (int value : count) {
            max = Math.max(value, max);
        }
        return people - max;
    }

    private boolean canCommunicate(int a, int b, Set<Integer>[] sets){
        for(int language: sets[a]){
            if(sets[b].contains(language)){
                return true;
            }
        }
        return false;
    }
}
