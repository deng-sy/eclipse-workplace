package hard;
//����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
//
//���磬����12��1��12��Щ�����а���1 ��������1��10��11��12��1һ��������5�Ρ�

public class countDigitOne {
    public static int countDigitOne(int n) {
        int cnt=0;//λ��
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
