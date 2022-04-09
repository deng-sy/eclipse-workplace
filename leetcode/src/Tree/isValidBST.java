package Tree;

import com.sun.source.tree.Tree;

public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    private boolean helper(TreeNode root,long max,long min){
        if(root==null)
            return true;
        if(root.val<=min||root.val>=max)
            return false;
        return helper(root.left,root.val,min)&&helper(root.right,max,root.val);
    }

    long pre=Long.MIN_VALUE;
    boolean flag;
    public boolean isValidBST2(TreeNode root){
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root==null||(!flag))
            return ;
        inorder(root.left);
        if(root.val<=pre)
            flag=false;
        pre=root.val;
        inorder(root.right);
    }
}
