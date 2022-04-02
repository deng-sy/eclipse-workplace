package BFS_DFS;
import java.util.*;
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

//叶子节点 是指没有子节点的节点。

public class pathSum {
    static List<List<Integer>>res=new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,new ArrayList<>(),targetSum,false);
        return res;

    }
    private static void dfs(TreeNode root,List<Integer>tmpList,int sum,boolean isLeaf){
        if(root==null){
            if(sum==0&&isLeaf)
                res.add(new ArrayList<>(tmpList));
            return ;
        }
        tmpList.add(root.val);
        sum-=root.val;
        isLeaf=root.left==null&&root.right==null;
        dfs(root.left,tmpList,sum,false);
        dfs(root.right,tmpList,sum,isLeaf);
        tmpList.remove(tmpList.size()-1);

    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.constructTree(new Integer[]{1,2});
        System.out.println(pathSum(root,1));
    }
}
