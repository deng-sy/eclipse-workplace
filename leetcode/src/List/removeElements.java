package List;
//����һ�������ͷ�ڵ� head ��һ������ val ������ɾ���������������� Node.val == val �Ľڵ㣬������ �µ�ͷ�ڵ� ��
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
