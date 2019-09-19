package Common;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#";
        return Integer.toString(root.val)+" "+serialize(root.left)+" "+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] list = data.split(" ");
        int []index = {0};
        return helper(list,index);
    }

    private TreeNode helper(String [] list,int[] index){
        String s = list[index[0]];
        if(s.equals("#")){
            index[0]++;
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(s));
            index[0]++;
            root.left = helper(list,index);
            root.right = helper(list,index);
            return root;
        }
    }
}
