package List;

import java.util.Arrays;

public class mergeLists {
//    µÝ¹é
    public static ListNode mergeLists1(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val<l2.val){
            l1.next=mergeLists1(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeLists1(l1,l2.next);
            return l2;
        }
    }
//    µü´ú
    public static ListNode mergeLists2(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next=l1==null?l2:l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(new int[]{1,4,9});
        ListNode l2=new ListNode(new int[]{2,3,8});
        System.out.println(ListNode.node2list(mergeLists2(l1,l2)));
    }
}
