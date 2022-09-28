package BFS_DFS;


import java.util.Deque;
import java.util.LinkedList;


//����ת��
public class ConstructTree {
    public static TreeNode constructTree(Integer[] nums){
        if(nums.length==0){return new TreeNode(0);}
        Deque<TreeNode> nodeDeque=new LinkedList<>();

        TreeNode root=new TreeNode(nums[0]);
        nodeDeque.offer(root);
        TreeNode cur;

//        ��¼��ǰ�нڵ��������������һ�зǿսڵ�����*2
        int lineNodeNum=2;

//        ��¼��ǰ���������������е���ʼλ��
        int startIndex=1;

//        ��¼�����е�ʣ��Ԫ������
        int restLength=nums.length-1;

        while (restLength > 0) {
            for(int i=startIndex;i<startIndex+lineNodeNum;i+=2){
                if(i==nums.length){return root;}
                cur=nodeDeque.poll();
                if(nums[i]!=null){
                    cur.left=new TreeNode(nums[i]);
                    nodeDeque.offer(cur.left);

                }
                if(i+1==nums.length){return root;}
                if(nums[i+1]!=null){
                    cur.right=new TreeNode(nums[i+1]);
                    nodeDeque.offer(cur.right);
                }
            }
            startIndex+=lineNodeNum;
            restLength=lineNodeNum;
            lineNodeNum=nodeDeque.size()*2;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums={5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root=constructTree(nums);
        TreeOperation.show(root);
    }
}
