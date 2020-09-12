package solution601_800;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
            queue.offer(root);
        }
        while(queue.size()>0){
            int size  = queue.size();
            double sum = 0;
            for(int i = 0; i<size;i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
