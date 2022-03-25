package List;

import java.util.Stack;

class isPalindrome {
	
	
//	递归调用，不断比较两边是否相等
	static ListNode tmp;
	public static boolean isPalindrome1(ListNode head) {
		tmp=head;
		return check(head);
	}
	
	private static boolean check(ListNode head) {
		if(head==null) {
			return true;
		}
		
		boolean res=check(head.next)&&(tmp.val==head.val);
		tmp=tmp.next;
		return res;
	}
	
	
//	反转后部分链表
	public boolean isPalindrome2(ListNode head) {
	    ListNode fast = head, slow = head;
	    //通过快慢指针找到中点，快指针移动2步，慢指针移动1步
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    //如果fast不为空，说明链表的长度是奇数个
	    if (fast != null) {
	        slow = slow.next;
	    }
	    //反转后半部分链表
	    slow = reverse(slow);

	    fast = head;
	    while (slow != null) {
	        //然后比较，判断节点值是否相等
	        if (fast.val != slow.val)
	            return false;
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	//反转链表
	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}

//	栈
	
	public boolean isPalindrome3(ListNode head) {
		ListNode tmp=head;
		Stack<Integer> stack=new Stack<Integer>();
		while(tmp!=null) {
			stack.push(tmp.val);
			tmp=tmp.next;
		}
		
		while(head!=null) {
			if(head.val!=stack.pop()) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	
	
	
    public static boolean result(int[] arr) {
		ListNode head=new ListNode(arr[0]);
		ListNode cur=head;
		for(int i=1;i<arr.length;i++) {		
			ListNode next=new ListNode(arr[i]);
			cur.next=next;
			cur=next;	
		}
		return isPalindrome1(head);
    }
    
	public static void main(String[] args) {
//		int[] arr= {1,3,2,1};
////
////		System.out.println(result(arr));
		System.out.println(Integer.MAX_VALUE);
	}
}
