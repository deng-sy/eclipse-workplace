package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给你二叉树的根结点root，请你设计算法计算二叉树的垂序遍历序列。对位于(row, col)
//的每个结点而言，其左右子结点分别位于(row+1, col -1)和(row+1, col+1)。树的根结
//点位于(0,0)。
//二叉树的垂序遍历从最左边的列开始直到最右边的列结束， 按 列 索 引 每 一 列 上 的 所 有 结
//点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结
//点的值从小到大进行排序。
public class verticalTraversal {
    public static List<List<Integer>>verticalTraversal(TreeNode root){
        List<int[]>mList=new ArrayList<>();
        dfs(root,0,0,mList);
        Collections.sort(mList,(arr1,arr2)->{
            if(arr1[2]!=arr2[2])
                return arr1[2]-arr2[2];
            if(arr1[1]!=arr2[1])
                return arr1[1]-arr2[1];
            return arr1[0]-arr2[0];
        });
//        System.out.println(mList);
        List<List<Integer>>res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<mList.size();i++){
            int[]arr=mList.get(i);
            int value=arr[0];
            if(i>0&&arr[2]!=mList.get(i-1)[2])
                res.add(new ArrayList<>());
            res.get(res.size()-1).add(value);
        }
        return res;

    }
    private static void dfs(TreeNode node,int i,int j,List<int[]>mList){
        if(node==null)
            return;
        mList.add(new int[]{node.val,i,j});
        dfs(node.left,i+1,j-1,mList);
        dfs(node.right,i+1,j+1,mList);
    }

    public static void main(String[] args) {
        Integer[]nums={1,2,3,4,5,6,7};
        TreeNode root=TreeNode.constructTree(nums);
        TreeNode.show(root);
        System.out.println(verticalTraversal(root));
    }
}


