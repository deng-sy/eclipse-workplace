package List;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//L0 → L1 → … → Ln - 1 → Ln
//请将其重新排列后变为：
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

public class reorderList {
    public static void reorderList(ListNode head){
        if(head==null)
            return ;
        ListNode mid=getMiddleNode(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;
        l2=reverseList(l2);
        merge(l1,l2);
    }
    private static ListNode getMiddleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode reverseList(ListNode head){
        ListNode pre=null,cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    private static void merge(ListNode l1,ListNode l2){
        ListNode tmp1,tmp2;
        while(l1!=null&&l2!=null){
            tmp1=l1.next;
            tmp2=l2.next;
            l1.next=l2;
            l1=tmp1;
            l2.next=l1;
            l2=tmp2;
        }
    }

}
