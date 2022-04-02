package BFS_DFS;

import java.util.*;

public class NumIslands {
//    dfs
    public static int numIslands1(char[][]grid){
        if(grid==null)
            return 0;
        int height=grid.length,width=grid[0].length;
        int num=0;
        char[][]tmp=new char[height][width];
        for(int i=0;i<height;i++)
            tmp[i]=Arrays.copyOf(grid[i],width);

        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                if(tmp[row][col]=='1'){
                    num++;
                    dfs(tmp,row,col);
                }
            }
        }
        return num;
    }
    private static void dfs(char[][]grid,int row,int col){
        int height=grid.length,width=grid[0].length;
        if(row<0||col<0||row>=height||col>=width||grid[row][col]=='0')
            return;
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }

//    bfs
    public static int numIslands2(char[][]grid) {
        if (grid == null)
            return 0;
        int height = grid.length, width = grid[0].length;
        int num = 0;
        char[][] tmp = new char[height][width];
        for (int i = 0; i < height; i++)
            tmp[i] = Arrays.copyOf(grid[i], width);

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (tmp[row][col] == '1') {
                    num++;
                    tmp[row][col]='0';
                    Queue<Integer>neighbors=new LinkedList<>();
                    neighbors.add(row*width+col);
                    while(!neighbors.isEmpty()){
                        int id=neighbors.remove();
                        int _row=id/width,_col=id%width;
                        if(_row-1>=0&&tmp[_row-1][_col]=='1'){
                            neighbors.add((_row-1)*width+_col);
                            tmp[_row-1][_col]='0';
                        }
                        if(_row+1<height&&tmp[_row+1][_col]=='1'){
                            neighbors.add((_row+1)*width+_col);
                            tmp[_row+1][_col]='0';
                        }
                        if(_col-1>=0&&tmp[_row][_col-1]=='1'){
                            neighbors.add((_row)*width+_col-1);
                            tmp[_row][_col-1]='0';
                        }
                        if(_col+1<width&&tmp[_row][_col+1]=='1'){
                            neighbors.add((_row)*width+_col+1);
                            tmp[_row][_col+1]='0';
                        }

                    }
                }

            }
        }
        return num;
    }
    public static void main(String[]args) {
        char[][]grid= {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands2(grid));

    }
}
