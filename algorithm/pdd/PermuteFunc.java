package pdd;
import java.util.*;
public class PermuteFunc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
        int n=sc.nextInt();
        getResult(n);
        }
    }
    private static void getResult(int n){
        if(n==1||n==2){
            System.out.println("1 1");
            return;
        }
        int min=getMin(n);
        int max=n-getMin(n-1);
        System.out.println(min+" "+max);
    }
    private static int getMin(int n){
        int tmp=(n-2)%4;
        if(tmp==1||tmp==2)
            return 0;
        return 1;
    }
}
