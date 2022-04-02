package BFS_DFS;
import java.util.*;
//����������ĸ��ڵ� root ��һ������Ŀ��� targetSum ���ҳ����� �Ӹ��ڵ㵽Ҷ�ӽڵ� ·���ܺ͵��ڸ���Ŀ��͵�·����

//Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣

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
