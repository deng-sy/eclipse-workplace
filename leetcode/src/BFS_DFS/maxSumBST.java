package BFS_DFS;
//为二叉搜索树的子树的最大节点和
class BST {
    boolean isBST;
    int val;
    int min;
    int max;
    int sum;
    public BST(boolean isBST, int min, int max, int sum) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}
public class maxSumBST {
    int maxSum=0;
    public int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        traverse(root);
        return maxSum;
    }

    private BST traverse(TreeNode root){
        if(root==null)
            return new BST(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        BST left=traverse(root.left);
        BST right=traverse(root.right);
        if(left.isBST&&right.isBST&&root.val>left.max&&root.val<right.min){
            int sum=left.sum+right.sum+root.val;
            maxSum=Math.max(sum,maxSum);
            int min=Math.min(left.min,root.val);
            int max=Math.max(right.max,root.val);
            return new BST(true,min,max,sum);
        }else
            return new BST(false,0,0,0);
    }



    public static void main(String[] args) {
        maxSumBST maxSumBST=new maxSumBST();
        TreeNode root=TreeNode.constructTree(new Integer[]{1,4,3,2,4,2,5,null,null,null,null,null,null,4,6});
        TreeNode.show(root);
//        System.out.println(result.left.right.isBST);
        System.out.println(maxSumBST.maxSumBST(root));
    }
}
