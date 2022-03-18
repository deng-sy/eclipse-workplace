package DoublePointers;

import java.util.LinkedList;
import java.util.List;

//���������ǿյ�������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ�������ķ�ʽ�洢
//�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡����㽫��������ӣ�������ͬ��ʽ����һ����ʾ
//�͵�����
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
