import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        int count=1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> one = new ArrayList<>();
            while(size-->0){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                one.add(queue.poll().val);
            }
            result.add(one);
        }
        return result;
    }
}
