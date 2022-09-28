package BFS_DFS;

public class exist {
    public boolean exist(char[][] board, String word) {
        int height=board.length,width=board[0].length;
        boolean[][] visited=new boolean[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                boolean flag=check(board,visited,i,j,word,0);
                if(flag)
                    return true;
            }
        }
        return false;
    }
    private boolean check(char[][]board,boolean[][]visited,int i,int j,String word,int idx){
        int height=board.length,width=board[0].length;
        if(board[i][j]!=word.charAt(idx))
            return false;
        else if(idx==word.length())
            return true;
        visited[i][j]=true;
        int[][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        boolean result=false;
        for(int[]dir:dirs){
            int new_i=i+dir[0],new_j=j+dir[1];
            if(new_i>=0&&new_i<height&&new_j>=0&&new_j<width){
                if(!visited[new_i][new_j]){
                    boolean flag=check(board,visited,new_i,new_j,word,idx+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;
        return result;
    }
}
