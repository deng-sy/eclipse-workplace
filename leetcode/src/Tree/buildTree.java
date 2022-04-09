package Tree;
import java.util.*;
//给定两个整数数组?preorder 和 inorder?，其中?preorder 是二叉树的先序遍历， inorder?是同一棵树的中序遍历，请构造二叉树并返回其根节点。

public class buildTree {

//    递归实现
    private static Map<Integer,Integer>indexMap;
    private static TreeNode helper(int[]preorder,int[]inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right)
            return null;
        int preorder_root=preorder_left;
        int inorder_root=indexMap.get(preorder[preorder_root]);
        TreeNode root=new TreeNode(preorder[preorder_root]);
        int size_left=inorder_root-inorder_left;
        root.left=helper(preorder,inorder,preorder_left+1,preorder_left+size_left,inorder_left,inorder_root-1);
        root.right=helper(preorder,inorder,preorder_left+size_left+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
    public static TreeNode buildTree(int[]preorder,int[]inorder){
        int n=preorder.length;
        indexMap= new HashMap<>();
        for(int i=0;i<n;i++)
            indexMap.put(inorder[i],i);
        return helper(preorder,inorder,0,n-1,0,n-1);

    }


    public static void main(String[] args) {
        int[]preorder={3,9,20,15,7};
        int[]inorder={9,3,15,20,7};
        TreeNode root=buildTree(preorder,inorder);
        TreeNode.show(root);
    }
}
