package List;

//����һ�������ͷ�ڵ� head ���ж��������Ƿ��л���
//�����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�
// ������ϵͳ�ڲ�ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����ע�⣺pos ����Ϊ�������д���?��������Ϊ�˱�ʶ�����ʵ�������
//��������д��ڻ�?���򷵻� true �� ���򣬷��� false ��

class hasCycle {
    //	�ݹ�ɾ���ڵ�
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

    //	����ָ��
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

    //	��⻷������λ��
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
