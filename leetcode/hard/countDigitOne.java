package hard;
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

public class countDigitOne {
    public static int countDigitOne(int n) {
        int cnt=0;//位数
        int tmp=n;
        while(tmp!=0){
            cnt++;
            tmp/=10;
        }
//        System.out.println(cnt);
        int res=0;
        long mod=10;
        for(int i=0;i<cnt;i++,mod*=10){
            res+=(n/mod)*(mod/10);
            if((n%mod)/(mod/10)==1)
                res+=(n%mod)%(mod/10)+1;
            else if((n%mod)/(mod/10)>1)
                res+=mod/10;
            System.out.println(mod+" "+res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(countDigitOne(1410065408));
    }
}
