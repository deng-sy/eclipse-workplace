package Tree;
import java.util.*;
public class findMode {
    List<Integer> res=new ArrayList();
    int pre;
    int cur_cnt;
    int max_cnt;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[]mode=new int[res.size()];
        for(int i=0;i<mode.length;i++)
            mode[i]=res.get(i);
        return mode;
    }

//    采用Morris中序遍历节省空间
    private void MorrisInorder(TreeNode root){
        TreeNode cur = root, pre ;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }



    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);

        update(root.val);

        inorder(root.right);
    }
    private void update(int val){
        if(val==pre)
            cur_cnt++;
        else{
            cur_cnt=1;
            pre=val;
        }
        if(cur_cnt==max_cnt)
            res.add(val);
        if(cur_cnt>max_cnt){
            max_cnt=cur_cnt;
            res.clear();
            res.add(val);
        }
    }


}
