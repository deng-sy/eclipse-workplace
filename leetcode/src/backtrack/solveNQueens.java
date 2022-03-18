package backtrack;


import java.util.Arrays;

//N皇后
public class solveNQueens {
    public static void solveNQueens(int n){
        char[][]chess=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                chess[i][j]='.';
        solve(chess,0);
    }

    public static void solve(char[][]chess,int row){
        if(row==chess.length){
            System.out.println(Arrays.deepToString(chess));
            return;
        }
        for(int col=0;col<chess.length;col++){
            if(valid(chess,row,col)){
//                char[][]tmp=copy(chess);
                chess[row][col]='Q';
                solve(chess,row+1);
                chess[row][col]='.';
            }
        }
    }
    private static char[][]copy(char[][]chess){
        char[][]tmp=new char[chess.length][chess[0].length];
        for(int i=0;i<chess.length;i++)
            for(int j=0;j<chess[0].length;j++)
                tmp[i][j]=chess[i][j];
            return tmp;
    }

    private static boolean valid(char[][]chess,int row,int col){
//        判断当前列有没有queen
        for(int i=0;i<row;i++){
            if(chess[i][col]=='Q')
                return false;
        }

//        判断右上角有没有queen
        for(int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++){
            if(chess[i][j]=='Q')
                return false;
        }
//        判断左上角有没有queen
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chess[i][j]=='Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
