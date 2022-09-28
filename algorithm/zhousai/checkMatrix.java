package zhousai;
//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
//
//矩阵对角线上的所有元素都 不是 0
//矩阵中所有其他元素都是 0
//给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
public class checkMatrix {
    public static boolean checkXMatrix(int[][] grid) {
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i==n-1-j){
                    if(grid[i][j]==0||grid[i][j]==0)
                        return false;
                }else
                    if(grid[i][j]>0)
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][]grid={{5,7,0},{0,3,1},{0,5,0}};
        System.out.println(checkXMatrix(grid));
    }
}
