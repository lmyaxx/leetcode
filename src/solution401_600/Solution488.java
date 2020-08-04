package solution401_600;

/**
 * @Author : Chad li
 * @Date : 2020/5/2 16:24
 * @Version 1.0
 */
public class Solution488 {
    public int findMinStep(String board, String hand) {
        int[] minStep = new int[]{Integer.MAX_VALUE};
        dfs(board,hand,minStep,0,0);
        return minStep[0]==Integer.MAX_VALUE ? -1: minStep[0];
    }

    private void dfs(String board, String hand, int[] minStep,int idx, int step){
        if(board.isEmpty()){
            minStep[0] = Math.min(step,minStep[0]);
        }
        for(int i=idx; i<hand.length();i++){
            for(int j=0;j<=board.length();j++){
                while(j<board.length()&&hand.charAt(i)==board.charAt(j)){
                    j++;
                }
                String newHand = hand.substring(0,i)+hand.substring(i+1);
                String newBoard = play(board.substring(0,j)+hand.charAt(i)+board.substring(j));
                dfs(newBoard, newHand, minStep, i, step+1);
            }
        }
    }
    private String play(String board){
        for(int i=1,j=0; i<board.length();i++){
            while(i<board.length()&&board.charAt(i)==board.charAt(j)){
                i++;
            }
            if(i-j>=3){
                return play(board.substring(j)+board.substring(0,i));
            }else{
                j=i;
            }
        }
        return board;
    }
}
