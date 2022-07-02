package jianzhi;
//给定一个?m x n 二维字符网格?board 和一个字符串单词?word 。如果?word 存在于网格中，返回 true ；否则，返回 false 。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

public class PathInMatrix {
    int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    char[][]board;
    String word;
    int h,w,n;
    boolean[][]vis;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        h=board.length;
        w=board[0].length;
        n=word.length();
        vis=new boolean[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(check(i,j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean check(int i,int j,int k){
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==n-1)
            return true;
        vis[i][j]=true;
        boolean res=false;
        for(int[]dir:dirs){
            int newi=i+dir[0],newj=j+dir[1];
            if(newi<0||newi>=h||newj<0||newj>=w)
                continue;
            if(!vis[newi][newj]&&check(newi,newj,k+1)){
                res=true;
                break;
            }
        }
        vis[i][j]=false;
        return res;
    }
}
