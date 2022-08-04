package zhousai;

public class equalPairs {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int ans=0;
        int[][]tmp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmp[i][j]=grid[j][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check(grid[i],tmp[j]))
                    ans++;
            }
        }
        return ans;
    }
    private boolean check(int[]nums1,int[]nums2){
        int n=nums1.length;
        for(int i=0;i<n;i++){
            if(nums1[i]!=nums2[i])
                return false;
        }
        return true;
    }

}
