package zhousai;
import java.util.*;

public class canChange {
    public static boolean canChange(String start, String target) {
        int n=start.length();
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            char ch=start.charAt(i);
            if(ch=='L'){
                queue.offer(new int[]{-1,i});
            }else if(ch=='R')
                queue.offer(new int[]{1,i});
        }
        for(int i=0;i<n;i++){
            char ch=target.charAt(i);
            if(ch=='L'){
                if(queue.isEmpty())
                    return false;
                int[]pos=queue.poll();
                if(pos[0]==1||pos[1]<i)
                    return false;
            }else if(ch=='R'){
                if(queue.isEmpty())
                    return false;
                int[]pos=queue.poll();
                if(pos[0]==-1||pos[1]>i)
                    return false;
            }
        }
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        String start="_L__R__R_L",target=  "L______RR_";
        System.out.println(canChange(start,target));
    }

}
