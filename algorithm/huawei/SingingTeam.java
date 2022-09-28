package huawei;
import java.util.*;

public class SingingTeam {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[]heights=new int[n];
        for(int i=0;i<n;i++){
            heights[i]=sc.nextInt();
        }
        int[]cnt=new int[n];
        int[]left=new int[n],right=new int[n];
        int len_left=0,len_right=n-1;
        left[len_left]=heights[0];
        right[len_right]=heights[n-1];
        for(int i=1;i<n;i++){
            if(heights[i]>left[len_left]){
                left[++len_left]=heights[i];
                cnt[i]+=len_left;

            }else{
                int low=0,high=len_left,pos=-1;
                while(low<=high){
                    int mid=(low+high)>>1;
                    if(heights[i]>left[mid]){
                        pos=mid;
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
                left[pos+1]=heights[i];
                cnt[i]+=pos+1;

            }
        }
        for(int i=n-2;i>=0;i--){
            if(heights[i]>right[len_right]){
                right[--len_right]=heights[i];
                cnt[i]+=(n-1-len_right);

            }else{
                int low=len_right,high=n-1,pos=n;
                while(low<=high){
                    int mid=(low+high)>>1;
                    if(heights[i]>right[mid]){
                        pos=mid;
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                right[pos-1]=heights[i];
                cnt[i]+=(n-pos);

            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,cnt[i]);
        }
        System.out.println(n-1-max);

    }

}
