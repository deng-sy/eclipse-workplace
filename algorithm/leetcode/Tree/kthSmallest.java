package Tree;

public class kthSmallest {
    static int ans=-1,idx=0;


    public static int kthSmallest(TreeNode root, int k) {

        // List<Integer>nums=new ArrayList();
        inorder(root,k);
        return ans;

    }
    private static void inorder(TreeNode root,int k){
        if(root==null||ans!=-1)
            return;

        inorder(root.left,k);
        idx++;
        if(idx==k){
            ans=root.val;

        }

        inorder(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.constructTree(new Integer[]{3,1,4,null,2});
        System.out.println(kthSmallest(root,1));
    }
}
