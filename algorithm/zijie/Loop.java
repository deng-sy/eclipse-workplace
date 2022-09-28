package zijie;
import java.util.*;
public class Loop {
    static StringBuilder loop =new StringBuilder();
    public static int getGCD(int divided,int divisor){
        if(divided<divisor){
            divisor^=divided;
            divided^=divisor;
            divisor^=divided;
        }
        while(divided%divisor!=0){
            int mod=divided%divisor;
            divided=divisor;
            divisor=mod;
        }
        return divisor;
    }
    public static String Loop(int divided,int divisor){
        if(divisor==1)
           return "No loop";
        int tmp=divisor;
        while(tmp!=1){
            if(tmp%2==0)
                tmp/=2;
            else if(tmp%5==0)
                tmp/=5;
            else
                break;
        }
        if(tmp==1)
            return "No loop";
        divided=divided%divisor;
        if(divided==0)
            return "No loop";

        int GCD=getGCD(divided,divisor);
        divided/=GCD;
        divisor/=GCD;
        int noLoop_cnt=0;
//        while(divisor%10==0){
//            divisor/=10;
//            noLoop_cnt++;
//        }
        int fenmu=9;
        int loop_cnt=1;
//        List<Map<Integer,Integer>>list=new ArrayList<>();
//        for(int i)
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(9);
//        while(fenmu%divisor!=0){
//            for(int i=0;i<queue.size();i++){
//
//            }
//        }
        List<Integer>list=new ArrayList<>();
        while(fenmu%divisor!=0){
            int size=queue.size();
            for(int i=1;i<=size;i++){
                fenmu=queue.poll();
                list.add(fenmu);
                loop_cnt=i;
                noLoop_cnt=size-i;
                if(fenmu%divisor==0){
                    break;
                }
                queue.offer(fenmu*10);
            }
            queue.offer(fenmu*10+9);
        }

        int loop_num=divided*fenmu/divisor;
        getRes(loop_num,loop_cnt);
        System.out.println(loop_num+" "+fenmu+" "+divided+" "+divisor+" "+loop_cnt);
        System.out.println(list);
        return loop.toString();
    }
    private static void getRes(int divided,int loop_cnt){
        if(loop_cnt==0){
            return ;
        }
        if(loop_cnt>0){
            getRes(divided/10,loop_cnt-1);
            loop.append(divided%10);
        }
    }
    public static String getRepetend(int a,int b){
        String decimal ="";
        List<Integer> temp = new LinkedList<>();
        a = a%b;
        loop:
        while(a!=0){
            if(!temp.contains(a))
                temp.add(a);
            else
                for(int i=0;i<temp.size();i++)
                    if(temp.get(i)==a) {
                        decimal = decimal.substring(i);
                        break loop;
                    }
            decimal += a*10/b;
            a = (a*10)%b;
            if(a==0){
                return "No Loop";
            }
        }

        return decimal;
    }
    public static void main(String[] args) {
//        System.out.print(getRepetend(1,5)) ;
//        System.out.print(Loop(2,990));
//        System.out.print(getGCD(26,4));
        System.out.println(getRepetend(2,990));

    }
}
