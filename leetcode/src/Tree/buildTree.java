package Tree;
import java.util.*;
//给定两个整数数组?preorder 和 inorder?，其中?preorder 是二叉树的先序遍历， inorder?是同一棵树的中序遍历，请构造二叉树并返回其根节点。

public class buildTree {

//    递归实现
    Map<Integer,Integer>indexMap;
    int[]preorder;
    private TreeNode helper(int preorder_left, int preorder_right, int inorder_left){
        System.out.println(preorder_left+" "+preorder_right+" "+inorder_left);
        if(preorder_left>preorder_right)
            return null;
        int preorder_root=preorder_left;
        int inorder_root=indexMap.get(preorder[preorder_root]);
        TreeNode root=new TreeNode(preorder[preorder_root]);
        int size_left=inorder_root-inorder_left;
        root.left=helper(preorder_left+1,preorder_left+size_left,inorder_left);
        root.right=helper(preorder_left+size_left+1,preorder_right,inorder_root+1);
        return root;
    }
    public TreeNode buildTree(int[]preorder,int[]inorder){
        int n=preorder.length;
        indexMap= new HashMap<>();
        for(int i=0;i<n;i++)
            indexMap.put(inorder[i],i);
        this.preorder=preorder;
        return helper(0,n-1,0);

    }


    public static void main(String[] args) {
        int[]preorder={3,9,20,15,7};
        int[]inorder={9,3,15,20,7};
        TreeNode root=new buildTree().buildTree(preorder,inorder);
        TreeNode.show(root);
    }
}
