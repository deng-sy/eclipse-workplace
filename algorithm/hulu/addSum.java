package hulu;

import java.util.*;

// Convert character to integer: `Character.getNumericValue()`
// Convert integer to character: `Character.forDigit()`
// Convert integer to string: `String.valueOf()` or `Integer.toString()`
// Convert string to integer: `Integer.valueOf()` or `Integer.parseInt()`

public class addSum {
    public String solution(String numStr1, String numStr2) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        // ÔÚÕâ?Ð´´úÂë
        String[]strs1=numStr1.split("."),strs2=numStr2.split(".");
        String a1=strs1[0],a2=strs2[0];
        String a=addString(a1,a2);
        StringBuilder ans=new StringBuilder();
        if(strs1.length>1&&strs2.length>1){
            String b1=strs1[1],b2=strs2[1];
            String b=addString(b1,b2);
            if(b.length()>Math.max(b1.length(),b2.length())){
                a=addString(a,"1");
                b=b.substring(1);
            }
            int i=b.length();
            for(;i>=0;i--){
                if(b.charAt(i-1)!='0'){
                    break;
                }
            }
            b=b.substring(0,i);
            ans.append(a);
            ans.append(".");
            ans.append(b);

        }else if(strs1.length>1){
            String b=strs1[1];
            ans.append(a);
            ans.append(".");
            ans.append(b);
        }
        else if(strs2.length>1){
            String b=strs2[1];
            ans.append(a);
            ans.append(".");
            ans.append(b);
        }else{
            ans.append(a);
        }
        return ans.toString();
    }
    private String addString(String a,String b){
        StringBuilder sb=new StringBuilder();
        int na=a.length(),nb=b.length();
        boolean add=false;
        int i=na-1,j=nb-1;
        while(i>=0||j>=0){
            int sum=add?1:0;
            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }
            if(j>=0){
                sum+=b.charAt(j--)-'0';
            }
            add=sum>=10;
            sb.append(sum%10);
        }
        if(add){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
