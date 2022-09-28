package tencent;


import java.util.LinkedList;
import java.util.List;

public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) {
    	this.val = x;
    }
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
	public ListNode(int[]arr){
        if(arr.length==0)
            return;
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for(int i=1;i<arr.length;i++) {
            ListNode next=new ListNode(arr[i]);
            cur.next=next;
            cur=next;
        }
        this.val=arr[0];
        this.next=head.next;

    }

    public static List<Integer> node2list(ListNode node){
        List<Integer>list=new LinkedList<>();
        ListNode cur=node;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        return list;
    }

    public static void main(String[] args) {
        int[]nums={1,2,3,4};
        ListNode node=new ListNode(nums);
        ListNode change=node;
        change.val=100;
//        System.out.println(node.next.next.next.val);
        System.out.println(node.val);
    }
    	    
 }
