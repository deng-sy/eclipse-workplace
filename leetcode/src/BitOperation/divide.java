package BitOperation;
//��������������������dividend�ͳ���divi sor�������������Ҫ��ʹ�ó˷�����
//����mod����������ر�����dividend���Գ���divi sor�õ����̡�
public class divide {
    public static int divide1(int dividend,int divisor){
        int sign=(dividend^divisor)>=0?1:-1;
        long dividendTmp=Math.abs((long)dividend);
        long divisorTmp=Math.abs((long)divisor);
        long res=0;
        while(dividendTmp>=divisorTmp){
            long tmp=divisorTmp;
            long times=1;
            while(dividendTmp>=(tmp<<1)){
                tmp<<=1;
                times<<=1;
            }
            dividendTmp-=tmp;
            res+=times;
        }
        res=sign>0?res:-res;
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)res;
    }

//    ����long
    public static int divide2(int dividend,int divisor){
        int sign=(dividend^divisor)>=0?1:-1;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        int res=0;

        int threshold=Integer.MIN_VALUE>>1;
        while(dividend<=divisor){
            int tmp=divisor;
            int times=1;
            while(tmp>=threshold&&dividend<=(tmp<<1)){
                tmp<<=1;
                times<<=1;

            }
            dividend-=tmp;
            res-=times;
        }
        if(res==Integer.MIN_VALUE&&sign==1)
            return Integer.MAX_VALUE;
        return sign<0?res:-res;
    }

//    ֻ��λ����,���üӼ���
    public static int divide3(int dividend,int divisor){
        boolean sign=(dividend^divisor)>=0;
        dividend=dividend<0?dividend:~subtraction(dividend,1);//��x���෴����~��x-1��
        divisor=divisor<0?divisor:~subtraction(divisor,1);
//        System.out.println(dividend);

        int res=0;
        int threshold=Integer.MIN_VALUE>>1;
        System.out.println(dividend+" "+divisor);
        while(dividend<=divisor){
            int tmp=divisor;
            int times=1;
            while(tmp>=threshold&&dividend<=(tmp<<1)){
                tmp<<=1;
                times<<=1;
            }
            dividend=subtraction(dividend,tmp);
            res=subtraction(res,times);

        }

        if(res==Integer.MIN_VALUE&&sign)
            return Integer.MAX_VALUE;
        return !sign?res:~subtraction(res,1);
    }

    public static int subtraction(int a,int b){
        if(b==0)
            return a;
        int c=a&b;
        a^=c;
        b^=c;
        return subtraction(a|b,b<<1);
    }

    public static void main(String[] args) {
        System.out.println(divide3(-2147483648,1));
//        System.out.println(substraction(10,2));
    }
}
