package wangyi;

import java.sql.ClientInfoStatus;
import java.util.*;

//最大不超过k且和为x的长度为n的数组
public class ConstructNums {
    static boolean find;
    public static List<Integer> ConstructNums(int n,int k,int x){
        find=false;

        List<Integer>res=new ArrayList<>();
        res.add(-1);
        if(k<n)
            return res;
        int min=0,max=0;
        for(int i=1;i<=n;i++){
            min+=i;
        }
        for(int i=k;i>k-n;i--){
            max+=i;
        }
        if(x<min||x>max)
            return res;
        res=new ArrayList<>();
        dfs(res,1,n,k,x);
        return res;
    }
    public static void dfs(List<Integer>list, int idx, int n, int k,int sum){
        if(list.size()==n&&sum==0){
            find=true;
            return;
        }
        if(list.size()==n||sum<0){
            return;
        }
        for(int i=idx;i<=k;i++){
            list.add(i);
            dfs(list,i+1,n,k,sum-i);
            if(find){
                return;
            }
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

            int n=sc.nextInt();
            long k=sc.nextLong();
            long x=sc.nextLong();

            List<Integer>res=ConstructNums(n, (int) Math.min(Integer.MAX_VALUE,k), (int) Math.min(Integer.MAX_VALUE,x));
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i));
                if(i!=res.size()-1)
                    System.out.print(" ");
            }
            System.out.println();
            sc.close();



    }
}
