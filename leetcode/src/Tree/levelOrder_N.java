package Tree;
import java.util.*;
//����һ�� N ������������ڵ�ֵ�Ĳ�����������������ң�����������
//�������л��������ò��������ÿ���ӽڵ㶼�� null ֵ�ָ����μ�ʾ������
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
