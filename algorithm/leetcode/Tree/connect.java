package Tree;
import java.util.*;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点.
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//初始状态下，所有?next 指针都被设置为 NULL。
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

//    法一：层序遍历
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
//    法二：基于已建立的next指针
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


//    法三：假如不是完全二叉树
    Node last=null,nextStart=null;
    public Node connect3(Node root){
        if(root==null)
            return null;
        Node start=root;
        while(start!=null){
            last=null;//当前节点的上一个
            nextStart=null;//每一层的最左节点
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
