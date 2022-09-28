package ali;
import java.util.Arrays;
import java.util.Scanner;
//Сǿ������n���ڵ�,�����������������ж����ֲ�ͬ�Ķ���������ڵ����Ϊ�����ĸ߶Ȳ������ķ���.��Ϊ�𰸺ܴ�,���Դ���Ҫģ��1e9+7�����.
//���ĸ߶�: ����Ϊ����Ҷ�ӵ���·���Ͻڵ���������ֵ.
public class Nums_Trees {
    public static long Nums_Trees(int n,int m){
        long[][]dp=new long[n+1][m+1];//dp[i][j]��ʾi���ڵ���ɵ���Ȳ�����j�Ķ�������������
        int mod=1000000007;
        Arrays.fill(dp[0],1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=1;k<=i;k++){
                    dp[i][j]+=dp[k-1][j-1]*dp[i-k][j-1]%mod;
                }
            }
        }

//        int low=Math.max(1, (int) (i-Math.pow(2,m-1)));
//        int high=Math.min(i,(int) (1+Math.pow(2,m-1)));
//        System.out.println(low+" "+high);

        return dp[n][m]%mod;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println(Nums_Trees(n,m));
        }
    }
}
