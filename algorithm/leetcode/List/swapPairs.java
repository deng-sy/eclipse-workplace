package List;
//����һ���������������������ڵĽڵ㣬�����ؽ����������ͷ�ڵ㡣������ڲ��޸Ľڵ��ڲ���ֵ���������ɱ��⣨����ֻ�ܽ��нڵ㽻����
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(cur!=null&&cur.next!=null){
            ListNode next=cur.next;
            pre.next=next;
            cur.next=next.next;
            next.next=cur;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
