package pdd;
import java.util.*;
public class MagicBox {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            System.out.println(getResult(n));
        }
    }
    private static int getResult(int n){
        if(n==1||n==2)
            return n;
        return getResult(n/2)+1;
    }
}
