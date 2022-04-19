package wangyi;

import java.sql.ClientInfoStatus;
import java.util.*;

//最大不超过k且和为x的长度为n的数组
public class ConstructNums {
    static boolean find;
    public static List<Long> ConstructNums(long n,long k,long x){
        find=false;

        List<Long>res=new ArrayList<>();
        res.add((long) -1);
        if(k<n)
            return res;
        long min=0,max=0;
        for(long i=1;i<=n;i++){
            min+=i;
        }
        for(long i=k;i>k-n;i--){
            max+=i;
        }
        if(x<min||x>max)
            return res;
        List<Long>new_res=new ArrayList<>();
        dfs(new_res,1,n,k,x);
        if(find)
            return new_res;
        else
            return res;
    }
    public static void dfs(List<Long>list, long idx, long n, long k,long sum){
        if(list.size()==n&&sum==0){
            find=true;
            return;
        }
        if(list.size()==n){
            System.out.println(sum);
            return;
        }

        for(long i=idx;i<=k;i++){
            list.add(i);
            dfs(list,i+1,n,k,sum-i);
            if(find){
                return;
            }
//            if(sum-i<0)
//                break;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long n=sc.nextInt();
            long k=sc.nextLong();
            long x=sc.nextLong();

            List<Long>res=ConstructNums(n, Math.min(Long.MAX_VALUE,k), Math.min(Long.MAX_VALUE,x));
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i));
                if(i!=res.size()-1)
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}
