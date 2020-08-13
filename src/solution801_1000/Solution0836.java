package solution801_1000;

public class Solution0836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //[x1, y1, x2, y2]
        //      left1 < right2 && left2 < right1
        return rec1[0]<rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
