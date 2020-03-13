/**
 * @Author : Chad li
 * @Date : 2020/3/13 10:32
 * @Version 1.0
 */
public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int down = Math.max(B,F);
        int width = right > left? right-left :0;
        int height = top > down ? top - down:0;
        return (int)(((long)(D-B))*(C-A) + ((long)(G-E)*(H-F)) - width*height);
    }
}
