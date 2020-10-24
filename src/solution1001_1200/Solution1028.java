package solution1001_1200;

import Common.TreeNode;

public class Solution1028 {
    public TreeNode recoverFromPreorder(String S) {
        char[] str = S.toCharArray();
        return helper(0,new int[]{0},str);
    }

    private TreeNode helper(int depth, int[] index, char[] str){
        if(index[0]>=str.length){
            return null;
        }
        int count = 0;
        while(index[0]+count<str.length&&str[index[0]+count]=='-'){
            count++;
        }
        if(count==depth){
            int num = 0;
            while(index[0]+count<str.length&&str[index[0]+count]>='0'&&str[index[0]+count]<='9'){
                num = num*10 + (str[index[0]+count] - '0');
                count++;
            }
            index[0]  +=  count;
            TreeNode root = new TreeNode(num);
            root.left = helper(depth+1,index,str);
            root.right = helper(depth+1,index,str);
            return root;
        }
        return null;
    }
}
