package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class sumRootToLeaf {
    static int res=0;
    public static int sumRootToLeaf_DFS(TreeNode root){
        dfs(root,0);
        return res;
    }
    private static void dfs(TreeNode root,int parentSum){
        if(root==null)
            return;
        int sum=parentSum*2+root.val;
        if(root.left==null&&root.right==null){
            res+=sum;
            return;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }

    public static int sumRootToLeaf_BFS(TreeNode root){
        int res=0;
        Queue<TreeNode>queueNode=new LinkedList<>();
        Queue<Integer>queueParentSum=new LinkedList<>();
        queueNode.add(root);
        queueParentSum.add(0);
        while(!queueNode.isEmpty()){
            TreeNode cur=queueNode.poll();
            int parenSum=queueParentSum.poll();
            int sum=parenSum*2+cur.val;
            if(cur.left==null&&cur.right==null){
                res+=sum;
                continue;
            }
            if(cur.left!=null){
                queueNode.add(cur.left);
                queueParentSum.add(sum);
            }
            if(cur.right!=null){
                queueNode.add(cur.right);
                queueParentSum.add(sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer nums[]={1,0,1,0,1,0,1};
        TreeNode root= ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        System.out.println(sumRootToLeaf_BFS(root));
    }
}
