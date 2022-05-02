package tencent;
//给出一个只包含 0 和 1 的 01 串 s ，下标从 1 开始，设第 i 位的价值为 vali ，则价值定义如下：
//1. i=1时:val1 = 1
//2. i>1时：
//2.1 若 si ≠ si-1 , vali = 1
//2.2 若 si = si-1 , vali = vali-1 + 1
//字符串的价值等于 val1 + val2 + val3 + ... + valn
//你可以删除 s 的任意个字符，问这个串的最大价值是多少。
public class StrValue {
    public static int StrValue(String str){
        int n=str.length();
        int[]sum=new int[n];
        sum[0]=1;
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+1;
            int match=1;
            for(int j=i-1;j>=0;j--){
                if(str.charAt(i)==str.charAt(j))
                    match++;
                else
                    sum[i]=Math.max(sum[i],sum[j]+(match*(match+1))/2);
            }
            sum[i]=Math.max(sum[i],(match*(match+1))/2);
        }
        return sum[n-1];
    }

    public static void main(String[] args) {
        String str="11111000111011101100";
        System.out.print(StrValue(str));
    }
}
