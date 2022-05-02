package List;

public class sortList {
    public static ListNode sortList(ListNode head){
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int len=0;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            len++;
        }
        for(int subLen=1;subLen<len;subLen<<=1){
            ListNode pre=dummy,cur=dummy.next;
            while(cur!=null){
                ListNode head1=cur;
                for(int i=1;i<subLen&&cur.next!=null;i++)
                    cur=cur.next;
                ListNode head2=cur.next;
                cur.next=null;
                cur=head2;
                for(int i=1;i<subLen&&cur!=null&&cur.next!=null;i++)
                    cur=cur.next;
                ListNode next=null;
                if(cur!=null){
                    next=cur.next;
                    cur.next=null;
                }
                ListNode merged=merge(head1,head2);
                pre.next=merged;
                while(pre.next!=null)
                    pre=pre.next;
                cur=next;
            }

        }
        return dummy.next;
    }



    private static ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                pre.next=head1;
                head1=head1.next;
            }else{
                pre.next=head2;
                head2=head2.next;
            }
            pre=pre.next;
        }
        pre.next=head1==null?head2:head1;
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head=new ListNode(new int[]{1,3,5,2,9});
        System.out.println(ListNode.node2list(sortList(head)));
    }
}
