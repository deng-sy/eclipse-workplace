package List;
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在
// 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。

public class partition {
    public static ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode last=dummy;
        while(head!=null){
            ListNode next=head.next;
            if(head.val<x){
                if(last.next==head){
                    last=last.next;
                }else{
                    head.next=last.next;
                    last.next=head;
                    last=last.next;
                    pre.next=next;
                }

            }else
                pre=head;
            head=next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    }
}
