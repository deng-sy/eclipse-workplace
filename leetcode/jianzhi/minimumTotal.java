package jianzhi;
import java.util.*;
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dist[i][0]=triangle.get(i).get(0);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<i+1;j++){
                dist[i][j]=Math.min(dist[i-1][j],dist[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dist[n-1][i]);
        }
        return ans;


    }
}
