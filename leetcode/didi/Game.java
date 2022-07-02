package didi;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            double[]speed=new double[n],time=new double[n];
            for(int i=0;i<n;i++){
                speed[i]=sc.nextInt();
            }

            for(int i=0;i<n;i++){
                time[i]=sc.nextInt();
            }
            double[]left=new double[n];
            for(int i=0;i<n;i++){
                left[i]=speed[i]*time[i];
            }
            double ans=0;
            PriorityQueue<double[]>pq=new PriorityQueue<>((o1, o2) -> (int) (o1[1]-o2[1]));
            for(int i=0;i<n;i++){
                pq.offer(new double[]{speed[i],time[i],left[i]});
            }
            while(!pq.isEmpty()){
                double[]game=pq.poll();
                ans+=game[1];
                int size=pq.size();
                int cnt=size;
                PriorityQueue<double[]>pqnew=new PriorityQueue<>((o1, o2) -> (int) (o1[1]-o2[1]));
                for(int i=0;i<size;i++){
                    double[]tmp=pq.poll();
                    tmp[2]-=tmp[0]*game[1];
                    tmp[0]+=game[0]/size;
                    tmp[1]=tmp[2]/tmp[0];
                    pqnew.offer(tmp);
                }
                pq=pqnew;
            }
            System.out.printf("%.4f",ans);

        }
    }
}
