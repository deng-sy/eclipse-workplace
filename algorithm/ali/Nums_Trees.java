package ali;
import java.util.Arrays;
import java.util.Scanner;
//小强现在有n个节点,他想请你帮他计算出有多少种不同的二叉树满足节点个数为且树的高度不超过的方案.因为答案很大,所以答案需要模上1e9+7后输出.
//树的高度: 定义为所有叶子到根路径上节点个数的最大值.
public class Nums_Trees {
    public static long Nums_Trees(int n,int m){
        long[][]dp=new long[n+1][m+1];//dp[i][j]表示i个节点组成的深度不超过j的二叉搜索树个数
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
