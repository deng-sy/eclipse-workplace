package Tree;
import java.util.*;
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class levelOrder_N {

    public List<List<Integer>>levelOrder(Node root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node>queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int cur_size=queue.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<cur_size;i++){
                Node parent=queue.poll();
                list.add(parent.val);
                for(Node node:parent.children){
                    queue.offer(node);
                }
            }
            res.add(list);

        }
        return res;
    }
}
