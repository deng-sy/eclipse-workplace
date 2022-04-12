package Tree;
import java.util.*;
//����һ�� ���������� ��������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ�.
//�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
//��ʼ״̬�£�����?next ָ�붼������Ϊ NULL��
public class connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

//    ��һ���������
    public Node connect1(Node root) {
        if(root==null)
            return null;
        Queue<Node>queue=new LinkedList<>();
        Node dummy=new Node(0);
        Node pre=dummy;
        queue.offer(root);
        while(!queue.isEmpty()){
            int cur_size=queue.size();
            for(int i=0;i<cur_size;i++){
                Node cur=queue.poll();
                if(i>0)
                    pre.next=cur;
                if(i==cur_size-1)
                    cur.next=null;
                pre=cur;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        return root;
    }
//    �����������ѽ�����nextָ��
    public Node connect2(Node root){
        if(root==null)
            return null;
        Node leftmost=root;
        while(leftmost.left!=null){
            Node head=leftmost;
            while(head!=null){
                head.left.next=head.right;
                if(head.next!=null)
                    head.right.next=head.next.left;
                head=head.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }


//    ���������粻����ȫ������
    Node last=null,nextStart=null;
    public Node connect3(Node root){
        if(root==null)
            return null;
        Node start=root;
        while(start!=null){
            last=null;//��ǰ�ڵ����һ��
            nextStart=null;//ÿһ�������ڵ�
            for(Node p=start;p!=null;p=p.next){
                if(p.left!=null)
                    handle(p.left);
                if(p.right!=null)
                    handle(p.right);

            }
            start=nextStart;
        }
        return root;
    }
    private void handle(Node p){
        if(last!=null)
            last.next=p;
        if(nextStart==null)
            nextStart=p;
        last=p;
    }
}
