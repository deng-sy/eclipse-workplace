package tencent;

import java.util.Arrays;

public class zhishu {
    boolean[]isZhishu;

    public int getNumber (int[] a) {
        int len=a.length;
//        boolean[]visited=new boolean[len];
        generate(len+1);
        int new_len=len;
        int cnt;
        while(len>1){
            cnt=0;
            for(int i=0;i<len;i++){
                if(isZhishu[i+1])
                    a[cnt++]=a[i];
            }
            len=cnt;
        }
        return a[0];
    }

    public void generate(int n){
        isZhishu=new boolean[n];
        boolean[]vis=new boolean[n];
        Arrays.fill(isZhishu,true);
        isZhishu[1]=false;
        for(int i=2;i<n;i++){
            if(vis[i])
                continue;
            for(int j=2;j*i<n;j++){
                isZhishu[j*i]=false;
                vis[j*i]=true;
            }
        }
    }
    public static void main(String[] args) {
        zhishu zhishu=new zhishu();
        int[]a={1,2,3,4};
        System.out.print(zhishu.getNumber(a));
//        zhishu.generate(100);
//        System.out.print(zhishu.isZhishu[15]);
    }
}
