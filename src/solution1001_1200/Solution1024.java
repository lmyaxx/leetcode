package solution1001_1200;

import java.util.Arrays;

public class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b)->{
            return a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0];
        });
        int max = 0, ans = 0;
        for(int i = 0; i< clips.length && max < T;){
            int dis = max;
            while(i<clips.length && clips[i][0]<=max){
                dis = Math.max(dis, clips[i][1]);
                i++;
            }
            if(dis == max){
                return -1;
            }
            max = dis;
            ans ++;
        }
        return max >= T ? ans : -1;
    }
}
