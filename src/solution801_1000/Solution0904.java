package solution801_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: chad li
 * @date: 2021/1/18
 * @discription:
 */
public class Solution0904 {
    public int totalFruit(int[] tree) {
        int len = tree.length;
        int[] pre = new int[len];
        for(int i = 1 ; i < len; i++){
            if(tree[i] == tree[i-1]){
                pre[i] = pre[i-1] + 1;
            }else{
                pre[i] = 0;
            }
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0,total = 0;
        for(int i = 0; i<tree.length; i++){
            if(set.size()<2||set.contains(tree[i]) ){
                set.add(tree[i]);
                total++;
            }else{
                total = pre[i-1] + 2;
                set.clear();
                set.add(tree[i]);
                set.add(tree[i-1]);
            }
            ans = Math.max(total,ans);
        }
        return ans;
    }
}
