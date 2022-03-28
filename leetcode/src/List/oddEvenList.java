package List;
//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节
//点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//请 尝 试 使 用 原 地 算 法 完 成 。 你 的 算 法 的 空 间 复 杂 度 应 为 O(1) ， 时 间 复 杂 度 应 为
//O(nodes )，nodes 为节点总数。
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
