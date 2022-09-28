package backtrack;

public class sumNumbers {
    int res=0;
    public int sumNumbers(TreeNode root){
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int parentSum){
        if(root==null)
            return;
        int sum=parentSum*10+root.val;
        if(root.left==null&&root.right==null)
            res+=sum;
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
