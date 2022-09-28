package zhousai;

import java.util.PriorityQueue;

public class fillCups {
    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int cup:amount){
            pq.offer(cup);
        }
        int ans=0;
        while(pq.peek()>0){
            int cup1=pq.poll(),cup2=pq.poll();
            ans++;
            pq.offer(cup1-1);
            pq.offer(cup2-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]amount={5,0,0};
        System.out.println(fillCups(amount));
    }
}
