package BFS_DFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//如果一棵二叉树满足下述几个条件，则可以称为奇偶树：
//二叉树根节点所在层下标为0，根的子节点所在层下标为1，根的孙节点所在层下标为
//2，依此类推。
//偶数下标层上的所有节点的值都是奇整数，从左到右按顺序严格递增
//奇数下标层上的所有节点的值都是偶整数，从左到右按顺序严格递减
//给你二叉树的根节点，如果二叉树为奇偶树，则返回true，否则返回fal se。
public class isEvenOddTree {
    public static boolean isEvenOddTree_BFS(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        boolean even=true;
        while(!queue.isEmpty()){
            int levelCount=queue.size();
            int preVal=even?Integer.MIN_VALUE:Integer.MAX_VALUE;
            while (levelCount-- > 0) {
                TreeNode cur=queue.poll();
                if((even&&(cur.val%2==0||cur.val<=preVal))||(!even&&(cur.val%2==1||cur.val>=preVal)))
                    return false;
                preVal=cur.val;
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            even=!even;
        }
        return true;
    }


    public static boolean isEvenOddTree_DFS(TreeNode root){
        List<Integer>mList=new ArrayList<>();
        return dfs(root,mList,0);
    }

    private static boolean dfs(TreeNode root,List<Integer>mList,int level){
        if(root==null)
            return true;
        if(root.val%2==level%2)
            return false;
        if(mList.size()>level){
            if((level%2==1&&mList.get(level)<=root.val)||(level%2==0&&mList.get(level)>=root.val))
                return false;
            mList.set(level,root.val);
    }else
            mList.add(root.val);
        return dfs(root.left,mList,level+1)&&dfs(root.right,mList,level+1);
}

    public static void main(String[] args) {
        Integer nums[]={1,10,5,3,null,7,9,12,8,6,null,null,2};
        TreeNode root= ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        System.out.println(isEvenOddTree_DFS(root));
    }
}
