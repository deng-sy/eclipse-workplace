package List;

public class removeNthFromEnd {

    ListNode left;
    ListNode right;
    int cnt;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        cnt=n;
        left=dummy;
        helper(head);
        left.next=right;
        return dummy.next;

    }
    private void helper(ListNode head){
        if(head==null)
            return;
        helper(head.next);
        cnt--;
        if(cnt==0)
            right=head.next;
        if(cnt==-1)
            left=head;
    }
}
