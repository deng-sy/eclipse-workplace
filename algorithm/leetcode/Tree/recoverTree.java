package Tree;


//恢复二叉搜索树:
//给你二叉搜索树的根节点root 该树中的两个节点的值被错误地交换。请在不改变其
//结构的情况下，恢复这棵树。

public class recoverTree {
    private static TreeNode pre;//当前节点的前一个节点
    private static TreeNode first;//第一个错误的节点
    private static TreeNode second;//第二个错误的节点
    public static void recoverTree(TreeNode root){
        inorder(root);

        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;


    }
//    中序遍历
    private static void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        if(first==null&&pre!=null&&pre.val>root.val){
            first=pre;
        }
        if(first!=null&&pre.val>root.val){
            second=root;
        }
        pre=root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums={3,1,4,null,null,2};
        TreeNode root=TreeNode.constructTree(nums);

        System.out.println("原始二叉树：");
        TreeNode.show(root);
        recoverTree(root);
        System.out.println();
        System.out.println("恢复后的二叉树：");
        TreeNode.show(root);
    }


}
