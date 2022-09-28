package huawei;

import java.util.Scanner;

public class IPClassification {
    static int cntA=0,cntB=0,cntC=0,cntD=0,cntE=0,cntWrong=0,cntPrivate=0;
    public static boolean isValidMask(String mask){
        String[]strs=mask.split("\\.");
        boolean hasZero=false;
        boolean hasOne=false;
        boolean isOne;
        int num;
        for(String str:strs){
            num=Integer.valueOf(str);
            for(int i=0;i<8;i++){
                isOne=((num>>(7-i))&1)==1;
                if(isOne&&!hasZero){
                    hasOne=true;
                    continue;
                }

                else if(isOne&&hasZero)
                    return false;
                else
                    hasZero=true;
            }
        }
        if(hasZero&&hasOne)
            return true;
        return false;
    }
    public static boolean isValidIP(String IP){
        String[]strs=IP.split("\\.");
//        if(strs[0].equals("127")||strs[0].equals("0"))
//            return false;
        if(strs.length<4)
            return false;
        return true;
    }
    public static boolean isSpecial(String IP){
        String[]strs=IP.split("\\.");
        int first=Integer.valueOf(strs[0]);
        if(first==0||first==127)
            return true;
        return false;
    }
    public static void Classification(String IP,String mask){
        String[]strs=IP.split("\\.");
        int first=Integer.valueOf(strs[0]);
        int second=Integer.valueOf(strs[1]);
        if(first>0&&first<127)
            cntA++;

        if(first>127&&first<192)
            cntB++;
        if(first>191&&first<224)
            cntC++;
        if(first>223&&first<240)
            cntD++;
        if(first>239&&first<256)
            cntE++;
        if(first==10||(first==172&&second>15&&second<32)||(first==192&&second==168))
            cntPrivate++;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]IP_mask;
        while(sc.hasNextLine()){
            IP_mask=sc.nextLine().split("~");
            String IP=IP_mask[0],mask=IP_mask[1];
            if(isSpecial(IP)){
//                 System.out.println("Special IP:"+IP);
                continue;
            }

            if(!isValidMask(mask)){
//                 System.out.println("Wrong mask:"+mask);
                cntWrong++;
                continue;
            }
            if(!isValidIP(IP)){
//                 System.out.println("Wrong IP:"+IP);
                cntWrong++;
                continue;
            }
            Classification(IP,mask);


        }
        System.out.println(cntA+" "+cntB+" "+cntC+" "+cntD+" "+cntE+" "+cntWrong+" "+cntPrivate);
    }

}
