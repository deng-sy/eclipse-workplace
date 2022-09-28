package List;

//给你一个链表的头节点 head ，判断链表中是否有环。
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环
// ，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递?。仅仅是为了标识链表的实际情况。
//如果链表中存在环?，则返回 true 。 否则，返回 false 。

class hasCycle {
    //	递归删除节点
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;

        }
        ListNode nextNode = head.next;

        head.next = head;
        return hasCycle1(nextNode);
    }

    //	快慢指针
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //	检测环并返回位置
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void result(int[] arr, int pos) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        ListNode cycleEnd = null;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            if (i == pos) {
                cycleEnd = next;
            }
            cur.next = next;
            cur = next;

            if (i == arr.length - 1) {
                cur.next = cycleEnd;
            }
        }
        System.out.println(cycleEnd.val);
        System.out.println(hasCycle1(head));
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int pos = 2;

//		result(arr,pos);
//		
//		ListNode a=new ListNode(1);
//		ListNode b=new ListNode(2);
//		ListNode c=a;
//		ListNode d=c;
//		c=b;
//
//		System.out.println(d.val);
    }
}
