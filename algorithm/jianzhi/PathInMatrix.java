package jianzhi;
//����һ��?m x n ��ά�ַ�����?board ��һ���ַ�������?word �����?word �����������У����� true �����򣬷��� false ��
//���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

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
