package List;
//����һ�����������е�����������������ͷ�ڵ�head������ɾ�����������д�����
//���ظ�����Ľڵ㣬ֻ����ԭʼ������û���ظ����ֵ����֡�����ͬ�����������еĽ��
//����
public class deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val)
                cur=cur.next;
            if(pre.next==cur)
                pre=pre.next;
            else
                pre.next=cur.next;
            cur=cur.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
//        int[]nums={1,1,2,2,3,3,4,4,5};
//        ListNode head=new ListNode(nums);
//        System.out.println(ListNode.node2list(deleteDuplicates(head)));
        ListNode dummy=new ListNode(0);
        ListNode head=new ListNode(1);
        ListNode cur=new ListNode(2);
        dummy.next=head;
        head.next=cur;
        ListNode pre=dummy;
        pre.next=head.next;
        System.out.println(dummy.next.val);



    }
}
