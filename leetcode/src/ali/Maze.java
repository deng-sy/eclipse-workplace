package ali;

public class Maze {
    public static int Maza(char[][]path){
        int time=0;
        int max_cnt=5;
        int n=path.length,m=path[0].length;
        boolean[][]hasObstacle = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(path[i][j]=='S'){

                }
                if(path[i][j]=='S'){

                }
                if(path[i][j]=='S'){
                    hasObstacle[i][j]=true;
                }

            }
        }
        return time;
    }
}
