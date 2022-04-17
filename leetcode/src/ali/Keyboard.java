package ali;
import java.util.*;
public class Keyboard {
    private static String Keyboard(String str){
        StringBuilder sb = new StringBuilder();
        char[]nums=str.toCharArray();
        int i=0;
        char lastChar = 0;
        char curChar=0;
        int lastNum=0;
        int cnt=0;
        char[][]dict={{},{},{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},
                {'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}};
        while(i<nums.length){
            int num=nums[i]-48;
            if(num==1){
                if(lastChar!=0){
                    sb.append(lastChar);
                    curChar=0;
                }

            }else{
                if(lastNum==num){
                    cnt++;
                }else{
                    if(lastChar!=0){
                        sb.append(lastChar);
                    }

                    cnt=0;
                }
                curChar=dict[num][cnt%dict[num].length];
            }
            lastNum=num;
            lastChar=curChar;
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            System.out.println(Keyboard(str));
        }
    }
}
