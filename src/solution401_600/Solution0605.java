package solution401_600;

/**
 * @author: chad li
 * @date: 2021/1/1
 * @discription:
 */
public class Solution0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        int count = 1;
        for(int num : flowerbed){
            if(num  == 0){
                count++;
            }else{
                ans += (count - 1) / 2;
                count = 0;

            }
        }
        count++;
        ans += (count - 1) / 2;
        return ans >= n;
    }
}
