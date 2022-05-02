package tencent;


public class Cycle {
    public static ListNode solve (ListNode[] a) {
        ListNode head=Construct(a);
        ListNode cur=head;
        int min=Integer.MAX_VALUE;
        ListNode pre=null;
        ListNode preNode=null;
        ListNode minNode=null;

        while(true){
            if(min>cur.val){
                preNode=pre;
                min=cur.val;
                minNode=cur;
            }
            pre=cur;
            cur=cur.next;
            if(cur==head){
                if(preNode==null){
                    preNode=pre;
                }
                break;
            }

        }
        if(minNode.next.val<preNode.val)
            return minNode;
        else{
            reverse(minNode);
            return minNode;
        }

    }

//    public static int getMin(ListNode node){
//
//    }
    public static void reverse(ListNode node){
        ListNode pre=null;
        ListNode cur=node;
        ListNode next;
        while(true){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            if(cur==node)
                break;

        }
        node.next=pre;
        return ;
    }

    public static ListNode Construct(ListNode[] a){
        if(a.length==1)
            return a[0];
        ListNode head=a[0];
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        for(int i=1;i<a.length;i++){
            ListNode node=a[i];
            while(node.next!=null){
                if(node.next.val==head.val){
                    tail.next=head;
                    break;
                }
                if(node.val==tail.val){
                    tail.next=node.next;
                    tail=tail.next;
                }
                node=node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(new int[]{10,20,3});
        ListNode node2=new ListNode(new int[]{20,3,4,5});
        ListNode node3=new ListNode(new int[]{5,6,10});
        ListNode[]a=new ListNode[]{node1,node2,node3};
//        ListNode head=Construct(a);
//        System.out.println(head.next.val);
//        System.out.println(reverse(head).next.val);
        ListNode res=solve(a);
        System.out.println(res.val+" "+res.next.val);

    }
}
