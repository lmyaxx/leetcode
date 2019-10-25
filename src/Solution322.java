/**
 * @Author : Chad li
 * @Date : 2019/10/25 15:43
 * @Version 1.0
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        result[0] = 1;
        for(int i = 0; i <= amount; i++){
            int temp = Integer.MAX_VALUE;
            boolean canChange = false;
            for(int coin:coins){
                if(i - coin >= 0 && result[i - coin] != 0){
                    canChange = true;
                    temp = Math.min(result[i - coin] + 1,temp);
                }
            }
            if(canChange){
                result[i] = temp;
            }
        }
        return result[amount] - 1;
    }
}
