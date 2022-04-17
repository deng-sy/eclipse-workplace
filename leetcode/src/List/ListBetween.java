package List;

public class ListBetween {
    public static ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        int cnt=0;
        ListNode leftNode = null,leftNodePre = null,rightNode = null;
        while(pre!=null){
            pre=pre.next;
            cnt++;
            if(cnt==left-1){
                leftNodePre=pre;
                leftNode=pre.next;
            }

            if(cnt==right)
                rightNode=pre;
        }
        ListNode cur=rightNode.next;
        leftNodePre.next=null;
        rightNode.next=null;
        reverseList(leftNode);
        leftNodePre.next=rightNode;
        leftNode.next=cur;
        return dummy.next;

    }
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[]nums={1,2,3,10,5};
        System.out.println(ListNode.node2list(reverseBetween(new ListNode(nums),2,4)));
    }
}
