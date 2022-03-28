package meituan;

import java.io.*;
import java.util.*;

//小美因为各种原因无法按时返校。为了完成学业，小美只能在家里上网课。网课由n个课程视频组成，编号为1到n。每个视频都需要从头看到尾才算完成该部分的学习，
// 且某些视频只能在看完指定的一些频之后才能开始播放。因为小美的学习能力和她用来上网课的电脑性能都很强，所以小美可以同时观看任意多个课程视频。
// 现在小美想知道，若她不眠不休地学习，每个课程视频最早能在她开始学习多长时间之后才能结束。
public class Vedio {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            int num=Integer.parseInt(line.trim());//视频个数
            String[]str;
            int[]time=new int[num+1];//每个视频的时长
            Vector<Vector> seq=new Vector<>();//seq[i]表示看第i个视频后可以看哪些视频
            for(int i=0;i<=num;i++)
                seq.add(new Vector());

            int[]end_time=new int[num+1];//表示这个视频什么时候看完，也就是最终结果
            boolean vis[]=new boolean[num+1];//表示看过没有
            Stack<Integer> watched=new Stack<>();//记录已经看过的视频
            int[]num_pre=new int[num+1];//表示需要看几个其他视频才能看当前的
            for(int i=1;i<=num;i++){
                str=br.readLine().split(" ");
                time[i]=Integer.parseInt(str[0]);
                int num_seq=Integer.parseInt(str[1]);
                num_pre[i]=num_seq;
                if(num_seq==0){
                    end_time[i]=time[i];
                    vis[i]=true;
                    watched.push(i);
                }
                for(int j=1;j<=num_seq;j++)
                    seq.get(Integer.parseInt(str[j + 1])).add(i);
            }
            int[]start_time=new int[num+1];
            while(!watched.isEmpty()){
                    int start=watched.pop();
                    Vector first=seq.get(start);
                    for(int i=0;i<first.size();i++){
                        int next= (int) first.get(i);
                        if(!vis[next]){
                            start_time[next]=Math.max(start_time[next],end_time[start]);
                            num_pre[next]--;
                        }
                        if(num_pre[next]==0){
                            watched.push(next);
                            vis[next]=true;
                            end_time[next]=start_time[next]+time[next];
                        }
                    }
                }
                for(int i=1;i<=num;i++)
                    System.out.print(end_time[i]+" ");
                System.out.println();

        }
    }
}


