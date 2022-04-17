package ali;

import java.util.*;

//Сǿ���ֵ���֪�Լ�ʱ,�ܺ����׵������ֵ.��Сǿ����������֪ �͵������,�������ֵ.��Ϊ���������ܴܺ�,�������е����㶼��ģ1e9+7�½���.
public class Xiaoqiang {
    public static long Xiaoqiang(int a,int b,int n){
        int mod=1000000007;
        long dp0=2;
        long dp1=a;
        long dp2=a*a-2*b;
        for(int i=2;i<=n;i++){
            dp2=((a*dp1)%mod-(b*dp0)%mod+mod)%mod;
            dp0=dp1;
            dp1=dp2;
        }
        return dp2;

    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int t=sc.nextInt();
            for(int i=0;i<t;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int n=sc.nextInt();
                System.out.println(Xiaoqiang(a,b,n));
            }
        }
    }
}
