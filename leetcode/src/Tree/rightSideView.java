package Tree;

import java.util.*;
public class rightSideView {
    public static List<Integer>rightSideView(TreeNode root){

        List<List<Integer>>ret=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return null;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer>level=new ArrayList<>();
            int cur_size=queue.size();

            for(int i=0;i<cur_size;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            ret.add(level);
            res.add(level.get(cur_size-1));
        }

        return res;
    }
}
