package zijie;

//二叉搜索树原地转有序双向链表
public class BinarySearch2DNodelist {
    static TreeNode head;
    static TreeNode tail;

    private static TreeNode inorder(TreeNode root){
        if(root==null)
            return null;
        inorder(root.left);
        if(head==null){
            head=root;
            tail=root;
        }else{
            tail.right=root;
            root.left=tail;
            tail=root;
        }
        inorder(root.right);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.constructTree(new Integer[]{1,0,2});
        TreeNode res=inorder(root);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.right;
        }
    }
}
