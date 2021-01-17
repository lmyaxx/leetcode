/**
 * @author: chad li
 * @date: 2021/1/17
 * @discription:
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int sx = coordinates[0][0], sy = coordinates[0][1];
        int disX = coordinates[1][0] - coordinates[0][0];
        int dixY = coordinates[1][1] - coordinates[0][1];
        //(y3-y1)*(disX)  = (disY) *(x3- x1)
        for(int i = 2; i < coordinates.length; i++ ){
            if((coordinates[i][1] - sy) * disX != dixY * (coordinates[i][0] - sx) ){
                return false;
            }
        }
        return true;
    }
}
