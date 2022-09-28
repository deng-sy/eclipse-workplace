package BFS_DFS;

public class longestIncreasingPath {
    int[][]matrix;
    int[][] memo;
    int rows,cols;
    int[][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        rows=matrix.length;
        cols=matrix[0].length;
        memo=new int[rows][cols];
        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans=Math.max(ans,dfs(i,j));
            }
        }
        return ans;
    }
    public int dfs(int row,int col){
        if(memo[row][col]>0)
            return memo[row][col];
        for(int[]dir:dirs){
            int new_row=row+dir[0],new_col=col+dir[1];
            if(new_row>=0&&new_row<rows&&new_col>=0&&new_col<cols&&matrix[new_row][new_col]>matrix[row][col]){
                memo[row][col]=Math.max(memo[row][col],dfs(new_row,new_col)+1);
            }
        }
        return memo[row][col];
    }
}
