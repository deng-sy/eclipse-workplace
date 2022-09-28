package weilai;
import java.util.*;
public class maxAvr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n=in.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            int ans=0;
            int[]sums=new int[n];
            sums[0]=nums[0];
            ans=Math.max(ans,sums[0]);
            for(int i=1;i<n;i++){
                sums[i]=sums[i-1]+nums[i];
                ans=Math.max(ans,sums[i]/(i+1));
            }
            for(int size=1;size<=n;size++){
                int sum=sums[size-1];
                for(int i=1;i<n-size+1;i++){
                    sum=sum-nums[i-1]+nums[i+size-1];
                    if(nums[i+size-1]<nums[i-1])
                        continue;
                    ans=Math.max(ans,sum/size);
                }
            }
            System.out.println(ans);
        }
    }
}
