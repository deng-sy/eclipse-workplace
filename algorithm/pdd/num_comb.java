package pdd;
import java.util.*;
public class num_comb{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int ans=0;
            int bit=1;
            boolean find=false;
            for(int i=9;i>=1;i--){
                if(n<=i){
                    ans+=n*bit;
                    find=true;
                    break;
                }else{
                    ans+=i*bit;
                    bit*=10;
                    n-=i;
                }
            }
            if(!find){
                System.out.println(-1);
            }else{
                System.out.println(ans);
            }
        }


    }
}
