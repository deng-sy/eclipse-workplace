package List;

import List.ListNode;

import java.util.Stack;

//��ת����
class reverseList {

//	˫����
    public static ListNode reverseList1(ListNode head) {
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
//    ջ

    public static ListNode reverseList2(ListNode head) {
    	Stack<ListNode> stack=new Stack<>();
    	while(head!=null) {
    		stack.push(head);
    		head=head.next;
    	}
    	if(stack.isEmpty()) {
    		return null;
    	}
    	
    	ListNode node=stack.pop();
    	ListNode dummy=node;
    	
    	while(!stack.isEmpty()) {
    		ListNode tmpNode=stack.pop();
    		node.next=tmpNode;
    		node=node.next;
    	}
    	
    	node.next=null;
    	return dummy;
    	

    }
  
//    �ݹ�
    public static ListNode reverseList3(ListNode head) {
    	return reverseListInt(head,null);
    }
    
    private static ListNode reverseListInt(ListNode head,ListNode newHead) {
    	if(head==null) {
    		return newHead;
    	}
    	ListNode next=head.next;
    	head.next=newHead; 
    	return reverseListInt(next,head);
    }
 
 
    
    public static int result(int[] arr) {
		ListNode head=new ListNode(arr[0]);
		ListNode cur=head;
		for(int i=1;i<arr.length;i++) {		
			ListNode next=new ListNode(arr[i]);
			cur.next=next;
			cur=next;	
		}
		return reverseList3(head).val;
    }
	
	
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {4,5,1,9};	
		System.out.println(result(arr));
		
	}

}