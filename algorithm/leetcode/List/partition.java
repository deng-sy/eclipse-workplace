package List;
//����һ�������ͷ�ڵ� head ��һ���ض�ֵ x �������������зָ���ʹ������ С�� x �Ľڵ㶼������
// ���ڻ���� x �Ľڵ�֮ǰ��
//
//��Ӧ�� ���� ����������ÿ���ڵ�ĳ�ʼ���λ�á�

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
