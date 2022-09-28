package jianzhi;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的
// 格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐
// 标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因
// 为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少
// 个格子

import java.util.LinkedList;
import java.util.Queue;

public class movingCount {
    public int movingCount(int m, int n, int k) {
        if(k==0)
            return 1;
        Queue<int[]>queue=new LinkedList<>();
        int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][]vis=new boolean[m][n];
        vis[0][0]=true;
        queue.offer(new int[]{0,0});
        int ans=1;
        while(!queue.isEmpty()){
            int[]cell=queue.poll();
            int x=cell[0],y=cell[1];
            for(int[]dir:dirs){
                int newx=x+dir[0],newy=y+dir[1];
                if(newx<0||newx>=m||newy<0||newy>=n||vis[newx][newy])
                    continue;
                vis[newx][newy]=true;
                if(check(newx,newy,k)){
                    queue.offer(new int[]{newx,newy});
                    ans++;
                }

            }
        }
        return ans;
    }
    private int getBitCnt(int num){
        int cnt=0;
        while(num!=0){
            cnt+=num%10;
            num/=10;
        }
        return cnt;
    }
    private boolean check(int x,int y,int k){
        return getBitCnt(x)+getBitCnt(y)<=k;
    }

}
