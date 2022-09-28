package Tree;
//给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
import java.util.ArrayList;
import java.util.List;

public class convertBST {
    List<Integer>nums=new ArrayList<>();
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        dfs(root);
        return root;
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        nums.add(root.val);
        sum+=root.val;
        root.val=root.val-sum;
        inorder(root.right);
    }
    private void dfs(TreeNode root){
        if(root==null)
            return ;
        dfs(root.left);
        root.val+=sum;
        dfs(root.right);

    }
}
