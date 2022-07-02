package didi;
import java.math.BigDecimal;
import java.util.*;
public class myPow{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String[]line=sc.nextLine().split(" ");
            for(int i=0;i<line.length;){
                String r=line[i++];
                int n=Integer.valueOf(line[i++]);
                System.out.println(power(r,n));
            }
        }
    }
    private static String power(String r,int n){
        String res="1";
        while(n-->0){
            res=multiply(r,res);
        }
        return res;
    }
    private static String multiply(String num1,String num2){
        BigDecimal float1=new BigDecimal(num1);
        BigDecimal float2=new BigDecimal(num2);
        return float1.multiply(float2).stripTrailingZeros().toPlainString();
    }
}
