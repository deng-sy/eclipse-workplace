package huawei;

import java.util.*;
public class EnglishNum{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            int[]nums=splitNum(str);
//        System.out.println(Arrays.toString(nums));
            String[]dic={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen",
                    "fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty",
                    "sixty","seventy","eighty","ninety"};
            String[]connect={"","thousand","million","billion"};
            int len=nums.length;
//            System.out.println(Arrays.toString(nums));
            for(int i=0;i<len;i++){
                int num=nums[i];
                if(num==0)
                    continue;
                if(i!=0)
                    System.out.print(" ");
                int[]bits=getBitNum(num);
                if(bits[0]!=0){
                    System.out.print(dic[bits[0]]+" hundred");
                    if(bits[1]!=0){
                        if(bits[1]==1)
                            System.out.print(" and "+dic[10+bits[2]]);
                        else{
                            System.out.print(" and "+dic[bits[1]-2+20]);
                            if(bits[2]!=0)
                                System.out.print(" "+dic[bits[2]]);
                        }

                    }else{
                        if(bits[2]!=0)
                            System.out.print(" and "+dic[bits[2]]);
                    }
                }else{
                    if(bits[1]!=0){
                        if(bits[1]==1)
                            System.out.print(dic[10+bits[2]]);
                        else{
                            System.out.print(dic[bits[1]-2+20]);
                            if(bits[2]!=0)
                                System.out.print(" "+dic[bits[2]]);
                        }

                    }else{
                        if(bits[2]!=0)
                            System.out.print(dic[bits[2]]);
                    }
                }
                System.out.print(" "+connect[len-i-1]);
//                if(num!=0&&i!=len-1&&i!=0)
//                    System.out.print(" and ");


            }
            System.out.println();
        }

    }
    public static int[] splitNum(String num){
        int len=num.length();
        int[]res=new int[(len-1)/3+1];
        int end,start;
        for(int i=len,cnt=res.length-1;i>0;i-=3,cnt--){
            end=i;
            start=Math.max(0,end-3);
            res[cnt]=Integer.valueOf(num.substring(start,end));
        }
        return res;
    }
    public static int[] getBitNum(int num){
        int[]res=new int[3];
        for(int i=0,mod=100;i<3;i++,mod/=10){
            res[i]=num/mod;
            num-=mod*res[i];
        }
        return res;
    }
}
