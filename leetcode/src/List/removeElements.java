package List;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(cur!=null){
            if(cur.val==val)
                pre.next=cur.next;
            else
                pre=cur;


            cur=cur.next;
        }
        return dummy.next;
    }
}
