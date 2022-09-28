package pdd;

import java.util.Scanner;
public class queue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n=in.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            int[]ret=new int[n];
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(nums[i]>nums[j])
                        ret[i]=Math.max(ret[i],j-i);
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(ret[i]+" ");
            }
        }
    }
}
