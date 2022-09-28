package hard;
import java.util.*;

public class maximalRectangle {
    public int maximalRectangle(String[] matrix) {
        int m=matrix.length;
        if(m==0)
            return 0;
        int n=matrix[0].length();
        int[][]left=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i].charAt(j)=='1'){
                    left[i][j]=(j==0?0:left[i][j-1])+1;
                }
            }
        }
        int ans=0;
        Deque<Integer>stack = new ArrayDeque<>();
        for(int j=0;j<n;j++){
            int[]up=new int[m],down=new int[m];
            Arrays.fill(down,m);
            for(int i=0;i<m;i++){
                while(!stack.isEmpty()&&left[stack.peek()][j]>=left[i][j]){
                    down[stack.peek()]=i;
                    stack.pop();
                }
                up[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            stack.clear();
            for(int i=0;i<m;i++){
                int height=down[i]-up[i]-1;
                int area=height*left[i][j];
                ans=Math.max(ans,area);
            }
        }
        return ans;

    }
}
