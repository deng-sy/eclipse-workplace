package tencent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class VerticalRead {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String line=sc.next();
            int m=line.length();
            StringBuilder[]sbs=new StringBuilder[m];
            int[]nums=new int[m];
            for(int i=0;i<m;i++){
                sbs[i]=new StringBuilder();
            }
            for(int j=0;j<m;j++){
                sbs[j].append(line.charAt(j));
            }
            for(int i=1;i<n;i++){
                line=sc.next();
//                System.out.println(line.charAt(0));
                for(int j=0;j<m;j++){
                    sbs[j].append(line.charAt(j));
                }
            }
            for(int i=0;i<m;i++){
                nums[i]=Integer.valueOf(sbs[i].toString());
//                System.out.println(nums[i]);
            }
            Arrays.sort(nums);
            for(int i=0;i<m;i++){
                System.out.print(nums[i]);
                if(i!=m-1){
                    System.out.print(" ");
                }
            }

        }
    }
}
