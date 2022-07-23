package zhousai;

import java.util.Arrays;

public class smallestTrimmedNumbers {
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len=nums[0].length();
        int[][]ret=new int[len+1][nums.length];
        for(int i=0;i<nums.length;i++){
            ret[0][i]=i;
        }
        int[][]tmpArray=new int[10][nums.length];
        for(int i=len-1;i>=0;i--){
            int[]cnt=new int[10];
            for(int j=0;j<nums.length;j++){
                String num=nums[ret[len-i-1][j]];
                int bit=num.charAt(i)-'0';
                tmpArray[bit][cnt[bit]++]=ret[len-i-1][j];
            }
            int idx=0;
            for(int j=0;j<10;j++){
                if(cnt[j]==0)
                    continue;
                for(int k=0;k<cnt[j];k++){
                    ret[len-i][idx++]=tmpArray[j][k];
                }
            }
        }
        int[]ans=new int[queries.length];
        int idx=0;
        for(int[]query:queries){
            int k=query[0],trim=query[1];
            ans[idx++]=ret[trim][k-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        String[]nums={"9415","5908","1840","5307"};
        int[][]queries={{3,2},{2,2},{3,3},{1,3}};
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums,queries)));
    }
}
