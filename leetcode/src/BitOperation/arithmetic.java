package BitOperation;
//ËÄÔòÔËËã
public class arithmetic {
    public static int add(int a,int b){
        if(a==0||b==0)
            return a^b;
        return add(a^b,(a&b)<<1);
    }

    public static int subtraction1(int a,int b){
        return add(a,add(~b,1));
    }

    public static int subtraction2(int a,int b){
        if(b==0)
            return a;
        int c=a&b;
        a^=c;
        b^=c;
        return subtraction2(a|b,b<<1);
    }

    private static int negative(int a){
        return add(~a,1);
    }

    public static int mult(int a,int b){
        int x=a<0?negative(a):a;
        int y=b<0?negative(b):b;
        int res=0;
        while(y!=0){
            if((y&1)==1)
                res=add(res,x);
            x<<=1;
            y>>=1;
        }
        return (a^b)>=0?res:negative(res);
    }

    public static int div(int a,int b){
        if(a==0||b==0)
            return 0;
        int x=a<0?negative(a):a;
        int y=b<0?negative(b):b;
        int res=0;
        for(int i=31;i>=0;i--){
            if((x>>i)>=y){
                res=add(res,1<<i);
                x=subtraction2(x,y<<i);
            }
        }
        return (a^b)>=0?res:negative(res);
    }

    public static void main(String[] args) {
        long time=System.nanoTime();
        System.out.println(add(10,14));
        System.out.println(subtraction2(10,14));
        System.out.println(mult(10,14));
        System.out.println(div(20,3));


//        System.out.println(System.nanoTime()-time);
    }
}
