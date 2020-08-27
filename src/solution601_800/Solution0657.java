package solution601_800;

public class Solution0657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y= 0;
        for(char ch: moves.toCharArray()){
            switch(ch){
                case 'U' : y ++;break;
                case 'D' : y --;break;
                case 'L' : x --;break;
                case 'R' : x ++;break;
            }
        }
        return x == 0 && y == 0;
    }
}
