package List;
//����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬�����������
//���ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
//�� �� �� ʹ �� ԭ �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� Ӧ Ϊ O(1) �� ʱ �� �� �� �� Ӧ Ϊ
//O(nodes )��nodes Ϊ�ڵ�������
public class oddEvenList {
    public static ListNode oddEvenList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode oddHead=head;
        ListNode oddCur=oddHead;
        ListNode evenHead=head.next;
        ListNode evenCur=evenHead;
        while(evenCur!=null&&evenCur.next!=null){
            oddCur.next=oddCur.next.next;
            evenCur.next=evenCur.next.next;
            oddCur=oddCur.next;
            evenCur=evenCur.next;
        }
        oddCur.next=evenHead;
        return oddHead;

    }
    public static void main(String[] args) {
        int[]nums={1,2,3,4,5};
        ListNode head=new ListNode(nums);
        System.out.println(ListNode.node2list(oddEvenList(head)));

    }
}
