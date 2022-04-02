package Tree;
//最近公共节点
public class lowestCommonAncestor {
    private static TreeNode res;
    private static boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return false;
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);
        if((lson&&rson)||(root.val==p.val||root.val==q.val)&&(lson||rson))
            res=root;
        return lson||rson||(root.val==p.val)||(root.val==q.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        dfs(root,p,q);
        return res;
    }
}
