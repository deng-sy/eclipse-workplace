package Tree;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
public class diameterOfBinaryTree {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        res=1;
        dfs(root);
        return res-1;
    }
    private int dfs(TreeNode node){
        if(node==null)
            return 0;
        int L=dfs(node.left);
        int R=dfs(node.right);
        res=Math.max(res,L+R-1);
        return Math.max(L,R)+1;
    }
}
