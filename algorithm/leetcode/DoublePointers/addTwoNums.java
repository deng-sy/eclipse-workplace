package DoublePointers;

import java.util.LinkedList;
import java.util.List;

//给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储
//的，并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示
//和的链表。
public class addTwoNums {
    public static ListNode addTwoNums(ListNode node1,ListNode node2){
        ListNode head=new ListNode(0);
        ListNode pre=head;
        int carry=0;
        while(node1!=null||node2!=null||carry!=0){
            int sum=carry;
            if(node1!=null){
                sum+=node1.val;
                node1=node1.next;
            }
            if(node2!=null){
                sum+=node2.val;
                node2=node2.next;
            }
            pre.next=new ListNode(sum%10);
            carry=sum/10;
            pre=pre.next;
        }

        return head.next;
    }
    public static void main(String[] args) {
        int[]num1={2,4,3},num2={5,6,4};
        ListNode node1=new ListNode(num1),node2=new ListNode(num2);
        ListNode.node2list(node1);
        System.out.println(ListNode.node2list(addTwoNums(node1,node2)));
    }
}
