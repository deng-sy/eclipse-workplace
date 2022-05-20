package huawei;
//若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成
// “素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称
// 为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。

//输入:
//有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
//输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
import java.util.*;
public class PrimePartners{
    static int odd_cnt=0;
    static int even_cnt=0;
    static int[]odds,evens;
    static boolean[]used;
    static int[]match;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]nums=new int[n];
        odds=new int[n];
        evens=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            if(nums[i]%2==0)
                evens[even_cnt++]=nums[i];
            else
                odds[odd_cnt++]=nums[i];
        }
        match=new int[even_cnt];
        used=new boolean[even_cnt];
        int res=0;
        Arrays.fill(match,-1);
        for(int i=0;i<odd_cnt;i++){
            Arrays.fill(used,false);
            if(find(i))
                res++;
        }
        System.out.println(res);

    }
    public static boolean isPrime(int x){
        if(x==1)
            return false;
        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

//    匈牙利算法
    public static boolean find(int idx){
        int odd=odds[idx];
        for(int i=0;i<even_cnt;i++){
            int even=evens[i];
            if(isPrime(even+odd)&&!used[i]){
                used[i]=true;
                if(match[i]==-1||find(match[i])){
                    match[i]=idx;
                    return true;
                }
            }
        }
        return false;
    }
}
