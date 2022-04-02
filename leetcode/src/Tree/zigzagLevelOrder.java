package Tree;
import java.util.*;
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode>queue=new LinkedList();
        queue.offer(root);
        boolean isOrderedLeft=false;
        while(!queue.isEmpty()){
            Deque<Integer>level=new LinkedList();
            int cur_size=queue.size();
            for(int i=1;i<=cur_size;i++){
                TreeNode node=queue.poll();
                if(isOrderedLeft)
                    level.offerFirst(node.val);
                else
                    level.offerLast(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

            }
            res.add(new LinkedList<>(level));
            isOrderedLeft=!isOrderedLeft;

        }
        return res;
    }
}
