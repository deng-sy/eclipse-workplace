package meituan;

import java.io.*;
import java.util.*;

//С����Ϊ����ԭ���޷���ʱ��У��Ϊ�����ѧҵ��С��ֻ���ڼ��������Ρ�������n���γ���Ƶ��ɣ����Ϊ1��n��ÿ����Ƶ����Ҫ��ͷ����β������ɸò��ֵ�ѧϰ��
// ��ĳЩ��Ƶֻ���ڿ���ָ����һЩƵ֮����ܿ�ʼ���š���ΪС����ѧϰ�����������������εĵ������ܶ���ǿ������С������ͬʱ�ۿ��������γ���Ƶ��
// ����С����֪�����������߲��ݵ�ѧϰ��ÿ���γ���Ƶ������������ʼѧϰ�೤ʱ��֮����ܽ�����
public class Vedio {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            int num=Integer.parseInt(line.trim());//��Ƶ����
            String[]str;
            int[]time=new int[num+1];//ÿ����Ƶ��ʱ��
            Vector<Vector> seq=new Vector<>();//seq[i]��ʾ����i����Ƶ����Կ���Щ��Ƶ
            for(int i=0;i<=num;i++)
                seq.add(new Vector());

            int[]end_time=new int[num+1];//��ʾ�����Ƶʲôʱ���꣬Ҳ�������ս��
            boolean vis[]=new boolean[num+1];//��ʾ����û��
            Stack<Integer> watched=new Stack<>();//��¼�Ѿ���������Ƶ
            int[]num_pre=new int[num+1];//��ʾ��Ҫ������������Ƶ���ܿ���ǰ��
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


