package List;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int len = getLength(head);
        k = k % len;
        if (len == 1 || k == 0)
            return head;
        int cnt = 0;
        ListNode dummy = new ListNode(0);
        ListNode new_tail = head;
        ListNode new_head = head;
        dummy.next = head;
        while (head.next != null) {
            head = head.next;
            cnt++;
            if (cnt == len - k - 1)
                new_tail = head;
            if (cnt == len - k)
                new_head = head;
        }
        new_tail.next = null;
        head.next = dummy.next;
        dummy.next = new_head;
        return new_head;
    }

    private int getLength(ListNode head) {
        int len = 0;
        if (head == null)
            return 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        rotateRight rotateRight = new rotateRight();
        ListNode head = new ListNode(new int[]{1, 2});
        System.out.print(ListNode.node2list(rotateRight.rotateRight(head, 0)));
    }
}
