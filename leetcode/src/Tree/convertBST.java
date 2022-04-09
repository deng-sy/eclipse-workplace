package Tree;

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
