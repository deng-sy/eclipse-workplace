package sangfor;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class reverseBetween {
    public ListNode reverseBetween(ListNode head) {
        // write code here
        ListNode left, leftPre = head;
        int i = 1;
        while (leftPre != null && i < 2) {
            leftPre = leftPre.next;
            i++;
        }
        left = leftPre.next;
        ListNode right = leftPre;
        while (right != null && i < 6) {
            right = right.next;
            i++;
        }
        ListNode rightNext = right.next;
        leftPre.next = right;
        ListNode pre = leftPre, cur = left;
        while (cur != rightNext) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        left.next = rightNext;
        return head;
    }
}
