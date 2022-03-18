package List;

class hasCycle {
	public static boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) {
			return false;
		}
		
		if(head.next==head) {
			return true;
			
		}
		ListNode nextNode=head.next;
		
		head.next=head;
		return hasCycle(nextNode);
	}
	
	public static void result(int[] arr,int pos) {
		ListNode head=new ListNode(arr[0]);
		ListNode cur=head;
		
		ListNode cycleEnd = null;
		for(int i=1;i<arr.length;i++) {		
			ListNode next=new ListNode(arr[i]);
			if(i==pos) {
				cycleEnd=next;
			}
			cur.next=next;
			cur=next;

			if(i==arr.length-1) {
				cur.next=cycleEnd;
			}
		}
		System.out.println(cycleEnd.val);
		System.out.println(hasCycle(head));
	}
	
	
	
	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5};
		int pos=2;
		result(arr,pos);
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
