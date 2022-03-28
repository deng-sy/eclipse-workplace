package meituan;
import java.io.*;
import java.util.*;
public class jinji {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int total_num=sc.nextInt();
            int promoted_num=sc.nextInt();
            int[]score=new int[total_num];
            for(int i=0;i<total_num;i++)
                score[i]=sc.nextInt();
            Arrays.sort(score);
            int cnt=0,key=0;
            for(int i=total_num-promoted_num;i<total_num;i++){
                if(score[i]>0){
                    key=score[i];
                    break;
                }

            }
            if(key>0){
                for(int i=0;i<total_num;i++){
                    if(score[i]>=key)
                        cnt++;
                }
            }

            System.out.println(cnt);

        }

    }
}
