package BFS_DFS;


import java.util.Deque;
import java.util.LinkedList;


//数组转树
public class ConstructTree {
    public static TreeNode constructTree(Integer[] nums){
        if(nums.length==0){return new TreeNode(0);}
        Deque<TreeNode> nodeDeque=new LinkedList<>();

        TreeNode root=new TreeNode(nums[0]);
        nodeDeque.offer(root);
        TreeNode cur;

//        记录当前行节点的数量，等于上一行非空节点数量*2
        int lineNodeNum=2;

//        记录当前行中数字在数组中的起始位置
        int startIndex=1;

//        记录数组中的剩余元素数量
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
