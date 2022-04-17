package baidu;

public class LongestIncreasePath {
    static int maxPath=0;
    public static int LongestIncreasePath(TreeNode root){
        if(root==null)
            return 0;
        maxPath = dfs(root);
        return maxPath;
    }
    private static int dfs(TreeNode root){
        if(root==null)
            return 1;
        int leftPath=1,rightPath=1;
        if(root.left!=null&&root.val<root.left.val)
            leftPath=dfs(root.left)+leftPath;
        else
            leftPath=dfs(root.left);
        if(root.right!=null&&root.val<root.right.val)
            leftPath=dfs(root.right)+rightPath;
        else
            rightPath=dfs(root.right);
        return Math.max(leftPath,rightPath);
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.constructTree(new Integer[]{10,5,3,6,1});
        TreeNode.show(root);
        System.out.println(LongestIncreasePath(root));
    }
}
