package didi;
import java.util.*;
public class Encoding {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String res=in.nextLine();
        String result=encode(res);
        System.out.println(result.length());
        System.out.println(result);
    }
    private static String encode(String s){
        if(s.length()<=4)
            return s;
        int len=s.length();
        int len2=len/2;
        int best_length=Integer.MAX_VALUE;
        int best_count=0;
        String pre="",cur="",pos="";
        while(len2>=1){
            for(int i=0;i<=len-len2;i++){
                int count=1;
                String s2=s.substring(i,i+len2);
                for(int j=1;i+len2*j+len2<=len;j++){
                    String s3=s.substring(i+len2*j,i+len2*j+len2);
                    if(s3.compareTo(s2)==0)
                        count++;
                    else
                        break;
                }
                int newLength=(len-len2*count)+len2+2+String.valueOf(count).length();
                if(newLength<len&& newLength<best_length&&count>1){
                    best_length=newLength;
                    best_count=count;
                    pre=s.substring(0,i);
                    cur=s2;
                    pos=s.substring(i+len2*count);
                }
            }
            len2--;
        }
        if(best_count==0)
            return s;
        return encode(pre)+ best_count +"["+encode(cur)+"]"+encode(pos);
    }
}
