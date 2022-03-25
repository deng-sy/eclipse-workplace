package Tree;


public class isBalanced {
    public static boolean isBalanced(TreeNode root){
        return height(root)>=0;
    }
    private static int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1)
            return -1;
        else
            return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.constructTree(new Integer[]{3,9,20,null,null,15,7});
        TreeNode.show(root);
        System.out.println(isBalanced(root));
    }
}
