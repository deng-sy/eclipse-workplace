package zhousai;

import com.sun.source.tree.Tree;

import java.util.*;

public class reverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (level % 2 == 1) {
                    cur.val = stack.pop();
                }
                if (cur.left == null)
                    continue;
                queue.offer(cur.left);
                queue.offer(cur.right);
                if (level % 2 == 0) {
                    stack.push(cur.left.val);
                    stack.push(cur.right.val);
                }
            }
            level++;
        }
        return root;
    }
}
