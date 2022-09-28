package BFS_DFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//���һ�ö���������������������������Գ�Ϊ��ż����
//���������ڵ����ڲ��±�Ϊ0�������ӽڵ����ڲ��±�Ϊ1��������ڵ����ڲ��±�Ϊ
//2���������ơ�
//ż���±���ϵ����нڵ��ֵ�����������������Ұ�˳���ϸ����
//�����±���ϵ����нڵ��ֵ����ż�����������Ұ�˳���ϸ�ݼ�
//����������ĸ��ڵ㣬���������Ϊ��ż�����򷵻�true�����򷵻�fal se��
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
