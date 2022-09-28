package List;


public class getKthFromEnd {
    ListNode res;
    int cnt;
    public ListNode getKthFromEnd(ListNode head,int k) {
        if(head!=null){
            getKthFromEnd(head.next,k);
            cnt++;
            if(cnt==k)
                res=head;
            return res;
        }
        return null;
    }


}
