package List;

public class mergeKlists {
    public static ListNode  mergeKLists(ListNode[]lists){
        return merge(lists,0,lists.length-1);
    }
    public static ListNode merge(ListNode[]lists,int left,int right){
        if(left==right)
            return lists[left];
        if(left>right)
            return null;
        int mid=(left+right)>>1;
        return mergeTwoLists(merge(lists,left,mid),merge(lists,mid+1,right));

    }

    public static ListNode mergeTwoLists(ListNode a,ListNode b){
        if(a==null||b==null)
            return a==null?b:a;
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                pre.next=a;
                a=a.next;
            }else{
                pre.next=b;
                b=b.next;
            }
            pre=pre.next;
        }
        pre.next=a==null?b:a;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[]lists=new ListNode[2];
        lists[0]=new ListNode(new int[]{1, 2, 5, 6});
        lists[1]=new ListNode(new int[]{3,4});
        System.out.println(ListNode.node2list(mergeKLists(lists)));
    }
}
