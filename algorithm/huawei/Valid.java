package huawei;

import java.util.*;
import java.util.regex.*;
public class Valid {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(str.length()<=8||getMatch(str)||getString(str,0,3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");

        }

    }
    public static boolean getString(String str,int l,int r){
        if(r>=str.length())
            return false;
        if(str.substring(r).contains(str.substring(l,r))){
            return true;
        }else
            return getString(str,l+1,r+1);
    }
    public static boolean getMatch(String str){
        int cnt=0;
        Pattern p1=Pattern.compile("[A-Z]");
        if(p1.matcher(str).find())
            cnt++;
        Pattern p2=Pattern.compile("[a-z]");
        if(p2.matcher(str).find())
            cnt++;
        Pattern p3=Pattern.compile("[0-9]");
        if(p3.matcher(str).find())
            cnt++;
        Pattern p4=Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find())
            cnt++;
        if(cnt>=3)
            return false;
        else
            return true;
    }
}
