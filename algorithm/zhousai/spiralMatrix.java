package zhousai;
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class spiralMatrix {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][]ret=new int[m][n];
        int l=0,r=n-1,u=0,d=m-1;
        for(int i=0;i<m;i++)
            Arrays.fill(ret[i],-1);
        while(l<=r&&u<=d){
            for(int i=l;i<=r;i++){
                if(head==null)
                    break;
                ret[u][i]=head.val;
                head=head.next;
            }
            for(int i=u+1;i<=d;i++){
                if(head==null)
                    break;
                ret[i][r]=head.val;
                head=head.next;
            }
            if(l<r&&u<d){
                for(int i=r-1;i>l;i--){
                    if(head==null)
                        break;
                    ret[d][i]=head.val;
                    head=head.next;
                }
                for(int i=d;i>u;i--){
                    if(head==null)
                        break;
                    ret[i][l]=head.val;
                    head=head.next;
                }
            }

            l++;r--;u++;d--;
        }
        return ret;
    }
}
