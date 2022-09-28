package List;
//¡¥±Ìµƒ≤Â»Î≈≈–Ú
public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode lastSorted=head,cur=head.next;
        while(cur!=null){
            if(lastSorted.val<=cur.val)
                lastSorted=lastSorted.next;
            else{
                ListNode pre=dummy;
                while(pre.next.val<=cur.val)
                    pre=pre.next;
                lastSorted.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;
            }
            cur=lastSorted.next;
        }
        return dummy.next;
    }
}
